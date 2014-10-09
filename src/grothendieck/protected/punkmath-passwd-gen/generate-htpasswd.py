#!/usr/bin/env python

import xkcdpass.xkcd_password as xkcdpw
import htpasswd
import csv
import sys
import os

KICKSTARTER_CSV = 'punkmathusers.csv'
USER_DATABASE = 'user.db'
WORDLIST = 'xkcdpassword.wordlist.txt'
CLEARTEXT_PASSWORDS = 'DO_NOT_DISTRIBUTE_password_file_DO_NOT_DISTRIBUTE'

if (len(sys.argv) < 2 or sys.argv[1] == '-h' or sys.argv[1] == '--help' or
    not os.path.exists('punkmathusers.csv')):

    print (
"""
To use, you'll need a CSV file called punkmathusers.csv that looks like:

    "Wil Langford","wil.langford@gmail.com"
    "Kellyn Bardeen","kellyn.bardeen@gmail.com"
    "Tom Henderson","tom@mathpunk.net"

So, name and email on each line.

Two files will be spit out.  One called DO_NOT_DISTRIBUTE_password_file_DO_NOT_DISTRIBUTE
that will look like this:

    "Wil Langford","wil.langford@gmail.com","billet aflutter adder rooter mendacity"
    "Kellyn Bardeen","kellyn.bardeen@gmail.com","thatch phagocyte sorriness hierarchy muffler"
    "Tom Henderson","tom@mathpunk.net","reviewer bootblack hedgerow liquefy headland"

And a file called user.db that looks like this:

    wil.langford@gmail.com:VKfe/twXXUrdw
    kellyn.bardeen@gmail.com:LZPTyaf9w./D6
    tom@mathpunk.net:HCJmVmM0ukcWo

You can rename the user.db file as .htpasswd (or whatever you want) and refer to it in an
.htaccess file to allow user logins.
""")
    sys.exit(0)

def read_file(filename):
    with open(filename,'r') as csvfile:
        lines = csv.reader(csvfile, delimiter=',', quotechar='"')

        data = [(email,name) for name,email in lines]

        return data

def gen_wordlist(filename):
    return xkcdpw.generate_wordlist(filename)

def write_htpasswd_file(user_filename):
    users = read_file(KICKSTARTER_CSV)
    wordlist = gen_wordlist(WORDLIST)

    for truncate_filename in [USER_DATABASE, CLEARTEXT_PASSWORDS]:
        with open(truncate_filename, 'w'):
            pass

    with htpasswd.Basic(user_filename) as userdb:
            with open(CLEARTEXT_PASSWORDS, 'w') as ctp:
                for email,name in users:
                    password = xkcdpw.generate_xkcdpassword(
                        wordlist,
                        n_words=5
                    )

                    ctp.write('"' +
                              '","'.join([name, email, password]) +
                              '"\n'
                    )


                    userdb.add(email, password)

write_htpasswd_file(USER_DATABASE)