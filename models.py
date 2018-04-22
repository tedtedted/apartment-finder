from app import db

class Listings(db.Model):
    """
    A table to store data on craigslist listings.
    """

    __tablename__ = 'listings'

    id = db.Column(db.Integer, primary_key=True)
    link = db.Column(db.String, unique=True)
    posted = db.Column(db.DateTime)
    inserted = db.Column(db.DateTime)
    price = db.Column(db.Float)
    geotag = db.Column(db.String)
    name = db.Column(db.String)
    location = db.Column(db.String)
    cl_id = db.Column(db.Integer, unique=True)
    area = db.Column(db.String)
