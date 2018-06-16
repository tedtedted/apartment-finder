import os
basedir = os.path.abspath(os.path.dirname(__file__))

class Config(object):
    # Database Settings
    SQLALCHEMY_DATABASE_URI = \
        'sqlite:///' + os.path.join(basedir, 'listings.db')
    SQLALCHEMY_TRACK_MODIFICATIONS = False

    # email settings
    MAIL_SERVER = 'smtp.gmail.com'
    MAIL_PORT = 587
    MAIL_USE_TLS = True
    MAIL_USE_SSL = False
    MAIL_USERNAME = ""
    MAIL_PASSWORD = ""
