(function() {
    const $deleteBtn = $(".wbdv-tbody").find("#wbdv-remove");
    const $createBtn = $("#wbdv-create");
    var $usernameFld = $('#usernameFld');
    var $passwordFld = $('#passwordFld');
    var $editBtn = $();
    var $firstNameFld = $('#firstNameFld');
    var $lastNameFld = $('#lastNameFld');
    var $roleFld = $('.wbdv-role');
    var $userRowTemplate = $('.wbdv-template');
    var $tbody = $('.tasble');
    //var userService = new AdminUserServiceClient();
    $(main);
    
    $deleteBtn.click(deleteUser)
    $createBtn.click(createUser)
    
    function main() {
	 
    }
    
     function createUser(event) {
	 
	 const username = $usernameFld.val()
	 const password = $passwordFld.val()
	 const firstname = $firstNameFld.val()
	 const lastname = $lastNameFld.val()
	 const role = $roleFld.val()
	 console.log(username, password, firstname, lastname);
	 
	 const row = $userRowTemplate.clone();
	 const usernameCol = row.find('.wbdv-username');
	 const firstnameCol = row.find('.wbdv-first-name');
	 const lastnameCol = row.find('.wbdv-last-name');
	 const role1 = row.find('.wbdv-role');
	 
	 usernameCol.html(username);
	 firstnameCol.html(firstname);
	 lastnameCol.html(lastname);
	 role1.html(role);
	 
	 $tbody.append(row);
	 
	 $usernameFld.val("");
	 passwordFld.val("")
	 firstNameFld.val("")
	 lastNameFld.val("")
	 
     }
    // function findAllUsers() { … }
    // function findUserById() { … }
     function deleteUser(event) {
	 console.log(event)
	 currentTarget = $(event.currentTarget)
	 const tr = currentTarget.parent().parent().parent();
	 tr.hide();
	 
     }
    // function selectUser() { … }
     function updateUser() {
    	
     }
    // function renderUser(user) { … }
    // function renderUsers(users) { … }
     
    
})();


