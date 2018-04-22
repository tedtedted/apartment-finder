from get_listings import get_listings
from mail import send_msg

try:
	print("Getting Listings")
	listings_now = get_listings()

	print(len(listings_now))

	print("sending email")
	msg_body = f"{len(listings_now)} places found just now"

	send_msg(body=msg_body)
	print("email sent")

except Exception as e:
	print("Something went wrong ... ")
	print(e)
