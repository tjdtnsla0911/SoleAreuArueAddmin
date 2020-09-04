
let index = {
		init: function(){
			$(".upload").on("click", ()=>{ // function(){} , ()=>{} this를
												// 바인딩하기 위해서!!
				this.uploadCoupon();
			});
			$(".btn-update").on("click", (e)=>{ // function(){} , ()=>{} this를
												// 바인딩하기 위해서!!
				console.log('안왔음');
				this.update(e);
			});
			$(".btn-delete").on("click", (e)=>{ // function(){} , ()=>{} this를
												// 바인딩하기 위해서!!
				this.userDelete(e);
			});

			$(".btn-ViewDetails").on("click", ()=>{ // function(){} , ()=>{} this를
				console.log('ViewDetails에 왓음');
this.ViewDetails();
});

		},




		uploadCoupon: function(){


			// alert('user의 save함수 호출됨');
			let data = {
					code:$("#code").val(),
					validityStart:$("#validityStart").val(),
					validityEnd: $("#validityEnd").val(),
					salePrice: $("#salePrice").val(),
					reason:$("#reason").val(),

			};
			if(data.code == ""||data.validityStart==""||validityEnd==""||salePrice==""){
				alert('빈값이있습니다!');
				return;
			}

			console.log('data = ',data);

			$.ajax({
				type: "POST",
				url: "/uploadCoupon",
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",

				dataType: "text"
			}).done(function(resp){
				console.log(resp);
				alert('성공');
//
					// location.href = "/list";


			}).fail(function(error){
				alert(JSON.stringify(error));
			});

		},







		start: function(){


			// alert('user의 save함수 호출됨');
			let data = {
					changebgImg : $("#imgs").val(),

			};


			$.ajax({
				 url : '/instar',
			        type : 'POST',
			        data : data,
			        contentType : false,
			        processData : false

			}).done(function(resp){
				console.log(resp);
				alert('성공');
//
					// location.href = "/list";


			}).fail(function(error){
				alert(JSON.stringify(error));
			});

		},





		// delete 하는곳
		userDelete: function(e){
			// alert('user의 save함수 호출됨');
			let temp = (e.target.id).replace("bt-delete-","");
			let data = {
					id: temp
			};
			console.log('최종 = ',data.id);
			$.ajax({
				type: "delete",
				url: "/listDelete/"+data.id,
				data: JSON.stringify(data), // http body데이터
				contentType: "application/json; charset=utf-8",// body데이터가 어떤
																// 타입인지(MIME)
				dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
									// json이라면) => javascript오브젝트로 변경
			}).done(function(resp){
				alert("회원삭제가 완료되었습니다.");
				console.log(resp);
				location.href = "/list";

			}).fail(function(error){
				alert(JSON.stringify(error));
			});



		},

		update: function(){
			console.log(event.target);
//			console.log('update에왔음');
//			console.log('e =',e);
//			let temp = (e.target.id).replace("bt-update-","");
//
//			$("#bt-update-1").

			let data2 = {
					id: temp
			};
			console.log('ajax안의 또다른 ajax의 id =',data2.id);

			$.ajax({
			type: "PUT",
			url: "/changeadsfasdf/"+data2.id,
			contentType: 'multipart/form-data',
			data: formData, // http body데이터
			 processData: false,
			 contentType: false,
			}).done(function(resp){
				alert("물품변경이 완료되었습니다.");
				// console.log(resp);
				// location.href = "/list";
			}).fail(function(error){
				alert(JSON.stringify(error));
			});
		},

		ViewDetails: function(){

			$.ajax({
				type: "get",
				url: "/makeNumber",
				contentType: "application/json; charset=utf-8",
				dataType: "text"
			}).done(function(resp){
				console.log(resp);
				$("#code").val(resp);

			}).fail(function(error){
				alert(JSON.stringify(error));
			});

		},
}

function test1(e){
	console.log(e);
	let temp = (e.target.id).replace("bt-update-","");//"bt-update-"+data.orders_detailId+"
	let data = {
			id: temp
	};
console.log("받아온 id값 = ",data.id)
let data2={
	stats : $("#stats"+data.id).val(),
	orders_detailId : data.id,
}
console.log("data2= ",data2);

$.ajax({
	type: "PUT",
	url: "/chaneStats/"+data.id,
	data: JSON.stringify(data2), // http body데이터
	contentType: "application/json; charset=utf-8",// body데이터가 어떤
	dataType: "text" // 요청을 서버로해서 응답이 왔을 때 기본적으로 모든 것이 문자열 (생긴게
						// json이라면) => javascript오브젝트로 변경
}).done(function(resp){

	console.log(resp);
	location.href="/orders"

}).fail(function(error){
	alert(JSON.stringify(error));
});


}




index.init();