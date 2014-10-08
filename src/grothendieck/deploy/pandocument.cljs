ns grothendieck.deploy.pandoc
require fs
require shell



pan a file
  the best options are a particular string
which i need to test to learn about.

  use the shell to run that option on the file.

pan a dir
  or map over the file.
  think seq ok?


preprocess for nanoformats



main
  be a lein task,
  take the dirs,
  do the right thing:
  for every file in the in dir,
  -<> f
     preprocess <>
     pan <> to outdir
  rsync to the right place
  signal success or failure


