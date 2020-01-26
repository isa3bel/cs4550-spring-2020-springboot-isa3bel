function AdminUserServiceClient() {
    this.findAllUsers = findAllUsers

     this.createUser = createUser;
     this.findAllUsers = findAllUsers;
     this.findUserById = findUserById;
     this.deleteUser = deleteUser;
     this.updateUser = updateUser;
     this.url =
     'https://wbdv-generic-server.herokuapp.com/api/isabelbolger/users';
     var self = this;
     
     
     function createUser(user) {
	        return fetch(self.url, {
	            method: 'POST',
	            body: JSON.stringify(user),
	            headers: {
	                "content-type": "application/json"
	            }
	        }).then(response => response.json())
	    }
     function deleteUser(userId) {
	 return fetch(`${self.url}/${userId}`, {
	     method: 'DELETE',
	 });
     }
   
}
