from datetime import datetime
import smtplib

import private

date = datetime.now().strftime("%B %d, %Y")

fromaddr = 'MessageFromTed@gmail.com'
toaddr = 'tedredington@gmail.com'

username = private.USERNAME
password = private.PASSWORD

def send_msg(body, toaddr=toaddr):

	msg = "\r\n".join([
		f"From: {fromaddr}",
		f"To: {toaddr}",
		f"Subject: Apt list for {date}",
		"",
		f"{body}"
		])

	server = smtplib.SMTP('smtp.gmail.com:587')
	server.ehlo()
	server.starttls()
	server.login(username, password)
	server.sendmail(fromaddr, toaddr, msg)
	server.quit()
