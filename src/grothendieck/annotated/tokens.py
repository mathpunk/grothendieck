# For reference, here’s a Python implementation of a token generator, suitable for
# dropping straight into your Flask or Django project:

import datetime
import jwt

# Replace these with your details
CONSUMER_KEY = 'yourconsumerkey'
CONSUMER_SECRET = 'yourconsumersecret'

# Only change this if you're sure you know what you're doing
CONSUMER_TTL = 86400

def generate_token(user_id):
    return jwt.encode({
      'consumerKey': CONSUMER_KEY,
      'userId': user_id,
      'issuedAt': _now().isoformat() + 'Z',
      'ttl': CONSUMER_TTL
    }, CONSUMER_SECRET)

def _now():
    return datetime.datetime.utcnow().replace(microsecond=0)

# Now all you need to do is expose an endpoint in your web application that returns the
# token to logged-in users (say, http://example.com/api/token), and you can set up the
# Annotator like so:

$(body).annotator()
       .annotator('setupPlugins', {tokenUrl: 'http://books.mathpunk.net/token'});
