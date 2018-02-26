from datetime import datetime
import json

from craigslist import CraigslistHousing
from dateutil.parser import parse

from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String, DateTime, Float, Boolean
from sqlalchemy.orm import sessionmaker

import settings

engine = create_engine('sqlite:///listings.db', echo=False)
Base = declarative_base()


class Listing(Base):
    """
    A table to store data on craigslist listings.
    """

    __tablename__ = 'listings'

    id = Column(Integer, primary_key=True)
    link = Column(String, unique=True)
    posted = Column(DateTime)
    inserted = Column(DateTime) 
    price = Column(Float)
    geotag = Column(String)
    name = Column(String)
    location = Column(String)
    cl_id = Column(Integer, unique=True)
    area = Column(String)


Base.metadata.create_all(engine)

Session = sessionmaker(bind=engine)
session = Session()

def get_listings():

    now = datetime.now().strftime('%B %d %Y %H%M')

    cl = CraigslistHousing(site=settings.CRAIGSLIST_SITE, area=settings.AREAS,
                       category=settings.CRAIGSLIST_CATEGORY,
                       filters={'max_price':settings.MAX_PRICE,
                                'min_price':settings.MIN_PRICE})

    results = cl.get_results(sort_by='newest')

    apts_found = []

    for result in results:

        listing = session.query(Listing).filter_by(cl_id=result["id"]).first()
        
        # filter by already seen apts 
        if listing is None:

            try:
                price = float(result["price"].replace("$",""))
            except:
                pass

            listing = Listing(
                link=result["url"],
                posted=parse(result["datetime"]),
                inserted=parse(now),
                name=result["name"],
                price=price,
                location=result["where"],
                cl_id=result["id"],
                area=result["area"],
                )  

            session.add(listing)
            session.commit()

            apts_found.append(result)

    return apts_found
