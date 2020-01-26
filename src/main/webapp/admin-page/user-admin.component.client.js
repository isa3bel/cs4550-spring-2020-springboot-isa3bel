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
    
function updateUser(user) {
	
	const username = $usernameFld.val()
	const password = $passwordFld.val()
	const firstName = $firstNameFld.val()
	const lastName = $lastNameFld.val()
	const role = $('#roleFld option:selected').text()
	
	let userNew = {
	    username: username,
	    password: password,
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
        	
        	
                // users.push(newUser)
                // renderUsers()
                findAllUsers()
                
            })
            
            currentUserId=-1;

    }
    
    function deleteUser(user) {
	currentTarget = $(event.currentTarget)
	const tr = currentTarget.parent().parent().parent();
	
	userService.deleteUser(user).then(response => {
	    tr.hide();
	    findAllUsers();
	})

    }
    
})();
