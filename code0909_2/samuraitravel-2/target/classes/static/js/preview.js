const imageInput = doucument.getElementById('imageFile');
const imagePreview = doucument.getElementById('imagePreview');

imageInput.addEventListener('change', () => {
	if (imageInput.file[0]) {
		let fileReader = new FileReader();
		fileReader.onload = () => {
			imagePreview.innerHTML = `<img src = "${fileReader.result}" class = "mb-3">`;
			
		}
		fileReader.readAsDataURL(imageInput.files[0]);
	} else {
		imagePreview.innerHTML = '';
	}
})