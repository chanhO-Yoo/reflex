document.addEventListener('DOMContentLoaded', function(){
	calShipItemPrice(); //배송비, 상품금액 계산
	usePoint(); //포인트 계산
}); 
/*
function pay(){
	IMP.request_pay({
		pg : 'inicis', 
		pay_method : 'card',
		merchant_uid : 'reflex' + new Date().getTime(),
		name : '<%=itemList.get(0).getItemName()%>',
		amount : userTotalPrice,
		buyer_email : '<%=m.getMemberEmail()%>',
		buyer_name : '<%=m.getMemberName()%>',
		buyer_tel : '<%=tel%>',
		buyer_addr : '<%=m.getMemberAddress()%>',
		buyer_postcode : '<%=m.getMemberPostcode()%>'
	}, function(rsp) {
		//결제 성공 시
		if ( rsp.success ) {
			$.ajax({
				url: "<%=request.getContextPath()%>/order/paymentsComplete",
				type: "post",
				data: {
					merchant_uid: rsp.merchant_uid,
					imp_uid: rsp.imp_uid,
					memberId: "<%=m.getMemberId()%>",
					payMethod: "card",
					itemList: <%=itemList%>,
					itemNoList: <%=itemNoList%>,
					eaMap: <%=eaMap%>,
					totalPrice: userTotalPrice
				},
				dataType: "json"
			}).done(function(data){
				var msg = '결제가 완료되었습니다.\n';
				msg += '고유ID : ' + rsp.imp_uid+"\n";
				msg += '상점 거래ID : ' + rsp.merchant_uid+"\n";
				msg += '결제 금액 : ' + rsp.paid_amount+"\n";
				msg += '카드 승인번호 : ' + rsp.apply_num+"\n";
				alert(msg);
			});
			//성공 시 이동
			location.href="<%=request.getContextPath()%>/order/orderSuccess";
		} 
		//결제 실패 시
		else {
			var msg = '결제에 실패하였습니다.\n';
			msg += '에러내용 : ' + rsp.error_msg;
			alert(msg);
			
			//실패 시 이동
			location.href="<%=request.getContextPath()%>/order/orderFail";
		}
	});
} //end of card 

//계좌이체 요청
if($radioChk==="trans"){
	IMP.request_pay({
		pg : 'inicis', 
		pay_method : 'trans',
		merchant_uid : 'merchant_' + new Date().getTime(),
		name : '주문명:결제테스트',
		amount : 14000,
		buyer_email : 'iamport@siot.do',
		buyer_name : '구매자이름',
		buyer_tel : '010-1234-5678',
		buyer_addr : '서울특별시 강남구 삼성동',
		buyer_postcode : '123-456',
		m_redirect_url : 'https://www.yourdomain.com/payments/complete'
	}, function(rsp) {
		if ( rsp.success ) {
			var msg = '결제가 완료되었습니다.';
			msg += '고유ID : ' + rsp.imp_uid;
			msg += '상점 거래ID : ' + rsp.merchant_uid;
			msg += '결제 금액 : ' + rsp.paid_amount;
			msg += '카드 승인번호 : ' + rsp.apply_num;
		} else {
			var msg = '결제에 실패하였습니다.';
			msg += '에러내용 : ' + rsp.error_msg;
		}
		alert(msg);
	});
} //end of trans
}
*/
function usePoint(){
	//포인트관련 변수
	let memberHavePoint = document.querySelector("#memberHavePoint").innerText;
	memberHavePoint = memberHavePoint.replace(",", "").replace("원", "")*1;
	let inputPoint = document.querySelector("#inputPoint"); //결제금액 사용포인트 입력태그
	let btnUseAll = document.querySelector("#btn-useAll"); //전액사용버튼
	let showUsePoint = document.querySelector("#showUsePoint"); //결제금액 사용포인트란
	let userPoint = document.querySelector("#userPoint"); //최종결제금액 포인트사용란
	
	//최종결제금액 변수
	let userItemPrice = document.querySelector("#userItemPrice").innerText; //주문상품
	let userShipPrice = document.querySelector("#userShipPrice").innerText; //배송비
	let userTotalPrice = document.querySelector("#userTotalPrice"); //총 결제금액
	userItemPrice = userItemPrice.replace(",","")*1;
	userShipPrice = userShipPrice.replace(",","")*1;
	
	//사용자가 포인트 입력한 후
	inputPoint.addEventListener('blur', function(){
		let val = this.value*1;
		let userPointNum = 0;
		
		//유효성검사
		if(val > memberHavePoint){
			alert("보유금액 이상 사용은 불가능합니다.");
			this.value = memberHavePoint;
			showUsePoint.innerText = memberHavePoint.toLocaleString();
			userPoint.innerText = memberHavePoint.toLocaleString();
			
			//총결제금액
			userPointNum = userPoint.innerText.replace(",", "");
			userTotalPrice.innerText = (userItemPrice+userShipPrice-userPointNum).toLocaleString();
			return;
		}
		
		showUsePoint.innerText = val.toLocaleString();
		userPoint.innerText = val.toLocaleString();
		
		//총결제금액
		userPointNum = userPoint.innerText.replace(",", "");
		userTotalPrice.innerText = (userItemPrice+userShipPrice-userPointNum).toLocaleString();
	});
	
	//전액사용 버튼 클릭한 경우
	btnUseAll.addEventListener('click', function(){
		inputPoint.value = memberHavePoint;
		showUsePoint.innerText = memberHavePoint.toLocaleString();
		userPoint.innerText = memberHavePoint.toLocaleString();
		
		//총결제금액
		userTotalPrice.innerText = (userItemPrice+userShipPrice-memberHavePoint).toLocaleString();
	});
	
}
function calShipItemPrice(){
	//상품정보 금액 변수 
	let itemPriceArr = document.querySelectorAll(".itemPrice"); //상품정보 주문상품금액
	let shipPrice = document.querySelector(".shipPrice").innerText; //상품정보 배송비
	//주문시 결제금액 변수 
	let showPrice = document.querySelector("#showPrice"); //주문시결제금액 주문금액(배송비포함)
	let totalItemPrice = 0; //총 주문상품금액
	let totalShipItemPrice = 0; //총 주문상품금액+배송비
	
	//최종결제금액 변수
	let userItemPrice = document.querySelector("#userItemPrice"); //주문상품
	let userShipPrice = document.querySelector("#userShipPrice"); //배송비
	let userTotalPrice = document.querySelector("#userTotalPrice"); //총 결제금액
	
	//주문시 결제금액 입력
	shipPrice = shipPrice.replace(",", "").replace("원", "")*1; //정수형 변환
	
	itemPriceArr.forEach(function(obj, idx){
		let objPrice = obj.innerText.replace(",", "").replace("원", "")*1;
		totalItemPrice += objPrice;
	})
	
	totalShipItemPrice = shipPrice+totalItemPrice;
	totalShipItemPrice = totalShipItemPrice.toLocaleString();
	
	showPrice.innerText = totalShipItemPrice;
	
	//최종결제금액 입력
	userItemPrice.innerText = totalItemPrice.toLocaleString();
	userShipPrice.innerText = shipPrice.toLocaleString();
	userTotalPrice.innerText = (totalItemPrice+shipPrice).toLocaleString(); //포인트제외
}


