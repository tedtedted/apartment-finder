from flask import Flask, render_template, request, url_for

from config import Config
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__)
app.config.from_object(Config)
db = SQLAlchemy(app)

from models import Listings


@app.route("/housing")
def index():

    page = request.args.get('page', 1, type=int)
    listing = Listings.query.order_by(Listings.posted.desc()).paginate(page=page, per_page=25)
    return render_template('listings.html', content=listing)


if __name__ == '__main__':
    app.run(host='0.0.0.0')
