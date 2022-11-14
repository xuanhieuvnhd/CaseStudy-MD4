let tk = localStorage.getItem("token");
let rl = localStorage.getItem("role");
// let token = "";
// let object = JSON.parse(rl);
if (tk == null){
    window.location.href = "Login.html"
}
function logout(){
    localStorage.removeItem("token");
    localStorage.removeItem("role");
    //goi API login
    window.location.href = "Login.html"
}
function getAllStudent() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("student").hidden = false;
    getStudent();
}
function getStudent() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/tuition/findMark",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            console.log(data)
            let content = '  <tr>\n' +
                '       <td style="font-size: 30px" >Full Name</td>\n' +
                '        <td style="font-size: 30px" >Lecture</td>\n' +
                '        <td style="font-size: 30px" >Tutorial</td>\n' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                content += getStudent1(data[i]);
            }
            document.getElementById("displayStudent").innerHTML = content;
        }
    })
}
function getStudent1(student) {
    return `<tr><td >${student.full_name}</td><td >${student.lecture}</td><td >${student.tutorial}</td>`
}

function getAllStudent1() {
    event.preventDefault();
    // document.getElementById("form-register").reset()
    document.getElementById("student").hidden = false;
    getStudent2();
}
function getStudent2() {
    $.ajax({
        type: "GET",
        //tên API
        url: "http://localhost:8080/tuition/findtuition",
        //xử lý khi thành công
        success: function (data) {
            // hien thi danh sach o day
            console.log(data)
            let content = '  <tr>\n' +
                '       <td style="font-size: 30px" >Full Name</td>\n' +
                '        <td style="font-size: 30px" >Class name</td>\n' +
                '        <td style="font-size: 30px" >Course name</td>\n' +
                '        <td style="font-size: 30px" >Completedfee</td>\n' +
                '        <td style="font-size: 30px" >Totalfee</td>\n' +
                '        <td style="font-size: 30px" >Debt</td>\n' +
                '</tr>';
            for (let i = 0; i < data.length; i++) {
                content += getStudent3(data[i]);
            }
            document.getElementById("displayStudent").innerHTML = content;
        }
    })
}
function getStudent3(tuition) {
    return `<tr><td >${tuition.full_name}</td><td >${tuition.name_class}</td><td >${tuition.name}</td><td >${tuition.completed_fee}</td><td >${tuition.total_fee}</td><td >${tuition.debt}</td>`
}


