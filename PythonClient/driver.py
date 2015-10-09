"""
Author: Massoud Maher
Purpose: Command-line application to demonstrate programatically access DAVID data
Strongly based on DAVIDWebService_Client.py file in this directory which was  not written by me
"""

# Found online to fix a bug. Required on Python 2.7.9+
import ssl
ssl._create_default_https_context = ssl._create_unverified_context

# Create a client usind wsdl
url = 'https://david.abcc.ncifcrf.gov/webservice/services/DAVIDWebService?wsdl'
client = Client(url)
# Also part of bug fix found online
client.wsdl.services[0].setlocation('https://david.ncifcrf.gov/webservice/services/DAVIDWebService.DAVIDWebServiceHttpSoap11Endpoint/')

# Authenticate with email
client.service.authenticate('mamaher@ucsd.edu')