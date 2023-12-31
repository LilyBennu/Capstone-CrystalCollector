// make request that post to that img controller point
// and get back the img url to post to objects 


function byId(id) {
    return document.getElementById(id);
}

const imgPreview = byId("imgPreview");
const preview = byId("preview");
let currentFile;

byId('theFile').addEventListener("change", function () {

    if (this.files.length === 0) {
        return;
    }

    let reader = new FileReader();
    reader.onload = function () {
        imgPreview.src = reader.result;
        preview.style.display = "block";
    };
    currentFile = this.files[0];
    reader.readAsDataURL(currentFile);

}, false);

// This sends the file to the Java backend (ImageUploadController.upload).
byId("btnUpload").addEventListener("click", function () {

    const formData = new FormData();
    formData.append("file", currentFile, currentFile.name);

    const init = {
        method: "POST",
        body: formData
    };

    fetch("/crystals/upload", init)
        .then((imageUrl) => console.log({}))
        .catch(console.error);
});


// when get image url 
// do post request to blurb img