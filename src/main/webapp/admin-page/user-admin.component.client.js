(function() {

    let users = [];
    const $deleteBtn = $(".wbdv-tbody").find("#wbdv-remove");
    const $createBtn = $("#wbdv-create");
    const $updateBtn = $(".wbdv-update");
    var $usernameFld = $('#usernameFld');
    var $passwordFld = $('#passwordFld');
    var $editBtn = $("#wbdv-edit");
    var $firstNameFld = $('#firstNameFld');
    var $lastNameFld = $('#lastNameFld');
    var $roleFld = $('.wbdv-role option:selected');
    var $userRowTemplate = $('.wbdv-template');
    var $tbody = $('.wbdv-tbody');
    var userService = new AdminUserServiceClient();
    
    
    function editUser(index) {	
        const userId = users[index]._id;
        currentUserId = userId;
        userService.findUserById(userId)
            .then(user => {
                $usernameFld.val(user.username)
                $firstNameFld.val(user.firstName)
                $lastNameFld.val(user.lastName)
                
                $('#roleFld').val(user.role)
                
            })
    }
    $(main);

    $deleteBtn.click(deleteUser)
    $createBtn.click(createUser)
    $editBtn.click(editUser)
    $updateBtn.click(updateUser)

    function main() {
	var promise = userService.findAllUsers();
	promise.then(renderUsers);
	
    }

    function createUser(event) {
	
	const username = $usernameFld.val()
	const password = $passwordFld.val()
	const firstname = $firstNameFld.val()
	const lastname = $lastNameFld.val()
	const role = $('#roleFld option:selected').text()
	

	const row = $userRowTemplate.clone();
	const usernameCol = row.find('.wbdv-username');
	const passwordCol = row.find('.wbdv-password');
	const firstnameCol = row.find('.wbdv-first-name');
	const lastnameCol = row.find('.wbdv-last-name');
	const role1 = row.find('.wbdv-role');
	const deleteBtn = row.find('#wbdv-remove');
	const editBtn = row.find('#wbdv-edit');
	deleteBtn.click(deleteUser);
	editBtn.click(editUser);
	
	var newUser = {
	            username: username,
	            password: password,
	            firstName: firstname,
	            lastName: lastname,
	            role: role,
	        }

	if (username == ("") && password == ("") && firstname == ("")
		&& lastname == ("")) {

	} else {

	    $usernameFld.val("");
	    $passwordFld.val("")
	    $firstNameFld.val("")
	    $lastNameFld.val("")
	   userService.createUser(newUser).then(() => findAllUsers())
	}
    }
    
   
    
    function findAllUsers() {
        userService.findAllUsers()
            .then((theUsers) => {
                users = theUsers
                renderUsers(users)
        })
        
    }
    
     function findUserById(userId) {
	 return fetch(self.url).then(response => response.json())
     }
     
    function deleteUser(user) {
	currentTarget = $(event.currentTarget)
	const tr = currentTarget.parent().parent().parent();
	
	userService.deleteUser(user).then(response => {
	    tr.hide();
	    findAllUsers();
	})

    }

    function updateUser(user) {
	
	const username = $usernameFld.val()
	const firstName = $firstNameFld.val()
	const lastName = $lastNameFld.val()
	const role = $('#roleFld option:selected').text()
	
	let userNew = {
	    username: username,
	    firstName: firstName,
	    lastName: lastName,
	    role: role
	}
        
        userService.updateUser(currentUserId, userNew)
            .then(newUser => {
        	$usernameFld.val("")
        	$passwordFld.val("")
        	$firstNameFld.val('')
        	$lastNameFld.val('')
        	
                findAllUsers()
                
            })
            
            currentUserId=-1;

    }
   

     function renderUser(user, u) {
	 const rowClone = $userRowTemplate.clone()
	    rowClone.removeClass('.wbdv-hidden')
	    rowClone.find('.wbdv-username').html(user.username)
	    rowClone.find('.wbdv-first-name').html(user.firstName)
	    rowClone.find('.wbdv-last-name').html(user.lastName)
	    rowClone.find('.wbdv-role').html(user.role)
	    rowClone.find("#wbdv-remove").click(() => {
		deleteUser(user._id)
	    });
	    rowClone.find('#wbdv-edit').click(() => {
		editUser(u)
	    })
	    $tbody.append(rowClone)
     }

    function renderUsers(users) {
	$tbody.empty();
	for ( var u in users) {
	    const user = users[u]
	    renderUser(user, u)
	}
	
    }
    findAllUsers()
})();
