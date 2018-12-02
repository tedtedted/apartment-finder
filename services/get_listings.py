from datetime import datetime
import json

from craigslist import CraigslistHousing
from dateutil.parser import parse

import profiles

from app import db
from models import Listings

def get_listings():

    now = datetime.now().strftime('%B %d %Y %H%M')

    cl = CraigslistHousing(site=profiles.CRAIGSLIST_SITE, area=profiles.AREAS,
                       category=profiles.CRAIGSLIST_CATEGORY,
                       filters={'max_price':profiles.MAX_PRICE,
                                'min_price':profiles.MIN_PRICE})

    results = cl.get_results(sort_by='newest')

    apts_found = []

    for result in results:

        listing = db.session.query(Listings).filter_by(cl_id=result["id"]).first()

        # filter by already seen apts
        if listing is None:

            try:
                price = float(result["price"].replace("$",""))
            except:
                pass

            listing = Listings(
                link=result["url"],
                posted=parse(result["datetime"]),
                inserted=parse(now),
                name=result["name"],
                price=price,
                location=result["where"],
                cl_id=result["id"],
                area=result["area"],
                )

            db.session.add(listing)
            db.session.commit()

            apts_found.append(result)

    return apts_found
