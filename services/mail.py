import sys
sys.path.append('..')

from flask import Flask, render_template
from flask_mail import Mail, Message

from datetime import datetime

from config import Config

app = Flask(__name__,template_folder='../templates')
app.config.from_object(Config)
mail = Mail(app)
date = datetime.now().strftime('%B %d, %Y')

def send_msg(number):

    with app.app_context():

        msg = Message(subject=f'Apt list for {date}',
                      sender=app.config.get("MAIL_USERNAME"),
                      recipients=["tedredington@gmail.com",],
                      html=render_template('email.html', number=number))
        mail.send(msg)
