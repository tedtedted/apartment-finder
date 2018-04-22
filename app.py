from flask import Flask, render_template

from config import config
from flask_sqlalchemy import SQLAlchemy


app = Flask(__name__)
app.config.from_object(Config)
db = SQLAlchemy(app)


@app.route("/")
def template_test():
    return render_template('listings.html', content=listing)


if __name__ == '__main__':
    from models import Listings
    app.run(host='0.0.0.0')
