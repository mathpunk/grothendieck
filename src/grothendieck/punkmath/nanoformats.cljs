ns nanoformats

defprotocol Nanoformat
  regex 
  part1, or caption
  part2, or data
  (html [n] "What md/html does the thing compile to? 
             Whenever possible, let pandoc do the work."
        default: just return the text, jerk. 
        )
  (notify [n] "Is a function that does something cool when a data value is null, and someone 
              asks it to."
        default: mail or exo brain Tom's devices or email account)
