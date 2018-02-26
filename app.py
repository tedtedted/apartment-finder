from flask import Flask, render_template

from sqlalchemy import create_engine
from sqlalchemy.ext.declarative import declarative_base
from sqlalchemy import Column, Integer, String, DateTime, Float, Boolean
from sqlalchemy.orm import sessionmaker

app = Flask(__name__)

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

listing = session.query(Listing).order_by(Listing.posted.desc()).limit(50).all()

listings = []
for item in listing:
    listings.append(item)

@app.route("/")
def template_test():
    return render_template('listings.html', content=listing)

if __name__ == '__main__':
    app.run(host='0.0.0.0')
