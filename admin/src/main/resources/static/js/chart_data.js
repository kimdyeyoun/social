$(function() {

	let date_type = 'day';
	let user_data = '';
	
	let payment_date_type = 'day'
	let search_type = 'payment_amount';
	let payment_data = '';
	let item_name = '총 결제금액';

	// 유저 정보 차트 
	$("#date_type").change(function() {
		date_type = $(this).val()

		$.ajax({
			type: 'post',
			url: 'user-data',
			contentType: 'application/x-www-form-urlencoded;charset=utf-8',
			data: {
				'date_type': date_type
			},
			success: (data) => {
				user_data = data
				google.charts.setOnLoadCallback(draw_userChart);
			}, error: (error) => {
				alert('차트 데이터 가져오기 실패')
			}
		})
	});
	
	// 온로드시 유저 가입 정보 가져옴
	$.ajax({
		type: 'post',
		url: 'user-data',
		contentType: 'application/x-www-form-urlencoded;charset=utf-8',
		data: {
			'date_type': date_type
		},
		success: (data) => {
			user_data = data
			google.charts.setOnLoadCallback(draw_userChart);
		}, error: (error) => {
			alert('차트 데이터 가져오기 실패')
		}
	})
	
	// 결제 정보 차트 변경
	$("#payment_date_type").change(function() {
		payment_date_type = $(this).val()

		$.ajax({
			type: 'post',
			url: 'payment-data',
			contentType: 'application/x-www-form-urlencoded;charset=utf-8',
			data: {
				'date_type': payment_date_type,
				'search_type' : search_type
			},
			success: (data) => {
				payment_data = data
				google.charts.setOnLoadCallback(draw_paymentChart);
			}, error: (error) => {
				alert('차트 데이터 가져오기 실패')
			}
		})
	});
	
	$(".payment_btn").click(function(){
		search_type = $(this).attr('id')
		item_name = $(this).text()
		
		$.ajax({
			type: 'post',
			url: 'payment-data',
			contentType: 'application/x-www-form-urlencoded;charset=utf-8',
			data: {
				'date_type': payment_date_type,
				'search_type' : search_type
			},
			success: (data) => {
				payment_data = data
				google.charts.setOnLoadCallback(draw_paymentChart);
			}, error: (error) => {
				alert('차트 데이터 가져오기 실패')
			}
		})
	})
	
	// 온로드시 결제 관련 차트 정보
	$.ajax({
		type: 'post',
		url: 'payment-data',
		contentType: 'application/x-www-form-urlencoded;charset=utf-8',
		data: {
			'date_type': payment_date_type,
			'search_type' : search_type
		},
		success: (data) => {
			payment_data = data
			google.charts.setOnLoadCallback(draw_paymentChart);
		}, error: (error) => {
			alert('차트 데이터 가져오기 실패')
		}
	})

	google.charts.load('current', { 'packages': ['line', 'corechart'] });

	
	// 유저 차트 그리기
	function draw_userChart() {
		var data = new google.visualization.DataTable();

		data.addColumn('string', 'day');
		data.addColumn('number', '가입 회원 수');

		for (let i = 11; i >= 0; i--) {
			data.addRows([
				[user_data[`date${i}`], user_data[`user_count${i}`]]
			])
		}

		var options = {
			seriesType: 'line',
			isStacked: true,
			bar: { groupWidth: "100%" }
		};

		function drawMaterialChart() {
			/* var materialChart = new google.charts.Line(chartDiv); */
			var materialChart = new google.visualization.ComboChart(document.getElementById('chart_div'));
			materialChart.draw(data, options);
		}

		drawMaterialChart();

		$(window).resize(function() {
			drawMaterialChart()
		})
	}
	
	
	// 결제 정보 차트 그리기
	function draw_paymentChart() {
		var data = new google.visualization.DataTable();

		data.addColumn('string', 'day');
		data.addColumn('number', item_name);

		for (let i = 11; i >= 0; i--) {
			data.addRows([
				[payment_data[`date${i}`], payment_data[`payment_data${i}`]]
			])
		}

		var options = {
			seriesType: 'line',
			isStacked: true,
			bar: { groupWidth: "100%" }
		};

		function drawMaterialChart() {
			/* var materialChart = new google.charts.Line(payment_chart_div); */
			var materialChart = new google.visualization.ComboChart(document.getElementById('payment_chart_div'));
			materialChart.draw(data, options);
		}

		drawMaterialChart();

		$(window).resize(function() {
			drawMaterialChart()
		})
	}

})	// function END