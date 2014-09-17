# grothendieck

Grothendieck defines static sites. 

----------------------------------------------------------------------------

build should...
read the files in the given directory
ignore the resources directory, but that ought to be linked in target
for all *.md files, turn them into the content and
  if-let [h :front content]
    if-let [t :template] 
      opt: use the header to read your template
      opt: do something with keywords
      set your title to that of :title,
      look just hand that map off to something that knows how to handle it ok
  finally,
    run the content through a template
    and spit it into target as (slug its-name).html
    
rebuild should...
  check to see if the mtime is new since last time
  what do you mean last time? ensure there is a file with a .deploy-history and cope that way
  for all for which that is true, 
    turn exactly those files into templated html that is spat at the target

deploy
  should be an rsync to the endpoint in the config.clj file
  

## Installation

Download from http://example.com/FIXME.

## Usage

FIXME: explanation

    $ java -jar grothendieck-0.1.0-standalone.jar [args]

## Options

FIXME: listing of options this app accepts.

## Examples

...

### Bugs

...

### Any Other Sections
### That You Think
### Might be Useful

## License

Copyright © 2014 FIXME

Distributed under the Eclipse Public License either version 1.0 or (at
your option) any later version.
