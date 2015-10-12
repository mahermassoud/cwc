"""
Author: Massoud Maher
Purpose: Command-line application to demonstrate programatically access DAVID data
Strongly based on DAVIDWebService_Client.py file in this directory which was  not written by me
"""

# Found online to fix a bug. Required on Python 2.7.9+
import ssl
ssl._create_default_https_context = ssl._create_unverified_context

import sys
sys.path.append('../')

import logging
from suds.client import Client
from suds import *
from tests import *
from datetime import datetime
import traceback as tb
import suds.metrics as metrics

ID_TYPE = 'OFFICIAL_GENE_SYMBOL'



"""
Description:	Gets list of gene IDs from user and returns them
Returns:		List of gene IDs using official gene symbol seperated by commas
"""
def get_input_ids():
	print "Input gene IDs using official gene symbol, separated by commas: "
	outputList = raw_input()
	return outputList


"""
Description:	Initializes DAVID client and authenticates. Changes state of passed in variables.
Returns:		DAVID client					
"""
def initialize():
	setup_logging()
	logging.getLogger('suds.client').setLevel(logging.DEBUG)

	# Create a client usind wsdl
	url = 'https://david.abcc.ncifcrf.gov/webservice/services/DAVIDWebService?wsdl'
	client = Client(url)
	# Also part of bug fix found online
	client.wsdl.services[0].setlocation('https://david.ncifcrf.gov/webservice/services/DAVIDWebService.DAVIDWebServiceHttpSoap11Endpoint/')

	# Authenticate with email
	client.service.authenticate('mamaher@ucsd.edu')
	return client

# Drier code
inputIds = get_input_ids()
client = initialize()

out_file = open('driver_out.txt', 'w')

client.service.addList(inputIds, ID_TYPE, 'input_list', 0)
out_file.write("test")
out_file.write(client.service.getListReport())