FROM python:3.6-alpine

MAINTAINER Ted Redington "tedredington@gmail.com"

COPY . /app
WORKDIR /app

RUN apk add --no-cache --update python3-dev gcc build-base

RUN apk add tzdata \
    && cp -r -r /usr/share/zoneinfo/America/Los_Angeles /etc/localtime

RUN pip install -r requirements.txt

EXPOSE 5001
ENTRYPOINT ["./deployment.run"]
