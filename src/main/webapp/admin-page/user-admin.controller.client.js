(function() {
    const $deleteBtn = $(".wbdv-tbody").find("#wbdv-remove");
    var $usernameFld, $passwordFld;
    var $removeBtn, $editBtn, $createBtn;
    var $firstNameFld, $lastNameFld, $roleFld;
    var $userRowTemplate, $tbody;
    //var userService = new AdminUserServiceClient();
    $(main);
    
    $deleteBtn.click(deleteUser)
    
    function main() {
	 
    }
    
    // function createUser() { … }
    // function findAllUsers() { … }
    // function findUserById() { … }
     function deleteUser(event) {
	 console.log(event)
	 currentTarget = $(event.currentTarget)
	 const tr = currentTarget.parent().parent().parent();
	 tr.hide();
	 
     }
    // function selectUser() { … }
    // function updateUser() {
    //	
    // }
    // function renderUser(user) { … }
    // function renderUsers(users) { … }
     
    
})();


