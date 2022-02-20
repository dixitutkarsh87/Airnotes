function createNew() {
    document.getElementById("notes_container").style.height = "250px";
    document.getElementById("notes_title").style.visibility = "visible";
    document.getElementById("save_notes").style.visibility = "visible";
    document.getElementById("save_notes").style.height = "40px";
    document.getElementById("notes_title").style.height = "40px";
    document.getElementById("notes_text").style.height = "110px";
    document.getElementById("notes_text").style.marginBottom = "-50px";
    document.getElementById("close_note").style.visibility = "visible";
}
function closeNew() {
    document.getElementById("notes_container").style.height = "30px";
    document.getElementById("notes_title").style.visibility = "hidden";
	document.getElementById("save_notes").style.visibility = "hidden";
    document.getElementById("notes_title").style.height = "0px";
    document.getElementById("save_notes").style.height = "0px";
    document.getElementById("notes_text").style.height = "40px";
    document.getElementById("notes_text").style.marginBottom = "0px";
    document.getElementById("close_note").style.visibility = "hidden";
    document.getElementById("notes_title").value = "";
    document.getElementById("notes_text").value = "";
}
function validateEmail() 
    {
		var email=document.getElementById("email").value;
        var re = /\S+@\S+\.\S+/;
		console.log(re.test(email));
        if (re.test(email)==0){
			document.getElementById("signup_button").disabled=true;
		}
		else{
			document.getElementById("signup_button").disabled=false;
		}
    }
function fetch_data(form_id){
	document.forms[form_id].submit()
}