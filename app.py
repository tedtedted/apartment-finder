from flask import Flask, render_template

from config import Config
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__)
app.config.from_object(Config)
db = SQLAlchemy(app)

from models import Listings

@app.route("/housing")
def index():

    listing = Listings.query.order_by(Listings.posted.desc()).limit(50)
    
    return render_template('listings.html', content=listing)


if __name__ == '__main__':
    # from models import Listings
    app.run(host='0.0.0.0')
