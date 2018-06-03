from services.get_listings import get_listings
from services.mail import send_msg

try:
	print("Getting Listings")
	listings_now = get_listings()

	print(len(listings_now))

	print("sending email")

	send_msg(number=len(listings_now))
	print("email sent")

except Exception as e:
	print("Something went wrong ... ")
	print(e)
