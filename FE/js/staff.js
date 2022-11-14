function logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    //goi API login
    window.location.href = "Login.html"
}
let tk = localStorage.getItem("token");
let rl = localStorage.getItem("role");
// let token = "";
// let object = JSON.parse(rl);
if (tk == null){
    window.location.href = "Login.html"
}
function getAllMark() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("mark").hidden = false;
    getMark();
}
function getMark() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/mark/findAll",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            console.log(data)
            let content = '  <tr>\n' +
                '       <td style="font-size: 30px" >Full Name</td>\n' +
                '        <td style="font-size: 30px" >Lecture</td>\n' +
                '        <td style="font-size: 30px" >Tutorial</td>\n' +
                '        <td style="font-size: 30px" >GPA</td>\n' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                content += getMark1(data[i]);
            }
            document.getElementById("displayMark").innerHTML = content;
        }
    })
}
function getMark1(mark) {
    return `<tr><td >${mark.full_name}</td><td >${mark.lecture}</td><td >${mark.tutorial}</td><td >${mark.gpa}</td>`
}
function getStudent() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("mark").hidden = false;
    getStudent1();
}
function getStudent1() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/mark/findStudent",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            console.log(data)
            let content = '  <tr>\n' +
                '       <td style="font-size: 30px" >Full Name</td>\n' +
                '        <td style="font-size: 30px" >Date Of Birth</td>\n' +
                '        <td style="font-size: 30px" >Address</td>\n' +
                '        <td style="font-size: 30px" >Email</td>\n' +
                '        <td style="font-size: 30px" >Phone Number</td>\n' +
                '        <td style="font-size: 30px" >Class</td>\n' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                content += getStudent2(data[i]);
            }
            document.getElementById("displayMark").innerHTML = content;
        }
    })
}
function getStudent2(student){
    return `<tr><td >${student.full_name}</td><td >${student.date_of_birth}</td><td >${student.address}</td><td >${student.email}</td><td >${student.phone_number}</td><td >${student.name_class}</td>`
}