# ssh

$ git config --global credential.helper cache
# Set git to use the credential memory cache
$ git config --global credential.helper 'cache --timeout=3600'
# Set the cache to timeout after 1 hour (setting is in seconds)

# owner:

- picture-settings-ssh and gpg keys.new ssh key-paste your ssh
- your ssh: rm -r .ssh  
- creat:ssh-keygen -t rsa -C "liukanglai" (or: email) 
- cat ~/.ssh/id_rsa.pub (copy it to github's ssh)
- ssh -T git@github.com (check)


## staff/employee

- give ssh
