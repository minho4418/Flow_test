/**
 * 
 */
 
const removeCheck = (e, path) => {
	e.preventDefault();
	let file_num = document.getElementsByName('file_num');
	
	for(let i = 0; i < file_num.length; i++){
		if(file_num[i].checked == true){
			location.href=path+'/check?file_num='+file_num[i].value;
		}
	}
}

const removeCheck2 = (e, path) => {
	e.preventDefault();
	let file_num = document.getElementsByName('file_num');
	
	for(let i = 0; i < file_num.length; i++){
		if(file_num[i].checked == false){
			location.href=path+'/check2?file_num='+file_num[i].value;
		}
	}
}

const add = (total_num,e, path) => {
	e.preventDefault();
	let file_extension = document.getElementById('file_extension');
	let remove_file = document.getElementsByName('remove_file');
	
	for(let i =0; i<remove_file.length; i++){
		if(remove_file[i].value === file_extension.value){
			file_extension.focus();
			alert('이미 추가된 확장자 입니다!');
		}
	}
	
	if (file_extension.value == '' ){
		file_extension.focus();
		alert('확장자를 입력하세요!');
	}
	else if (file_extension.value.length > 20 ){
		file_extension.focus();
		alert('최대 입력 길이는 20자리입니다!');
	}
	else if (total_num > 200){
		file_extension.focus();
		alert('확장자는 최대 200개까지 추가가 가능합니다!');
	}
	else{
			location.href=path+'/add?file_extension='+file_extension.value;
		}
	
}

const remove = (custom_num,e, path) => {
	e.preventDefault();
	let remove_file = document.getElementsByName('remove_file');
	
	location.href=path+'/remove?remove_file='+remove_file[custom_num].value;
	
}

const deleteAll = (e, path) => {
	e.preventDefault();
	let file_check = document.getElementsByName('remove_file');
	
	location.href=path+'/removeAll?file_check=';
	
}