<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01//EN" "http://www.w3.org/TR/html4/strict.dtd">
<html>

<head>

	<head>
	
		<Title> Tripency </Title>
		<link rel="stylesheet" type="text/css" href="styles.css">
	
	<script
src="http://maps.googleapis.com/maps/api/js?key=AIzaSyAVOKugu3Z_4x_ylV5hUXyMFKhcWKCH6eo&sensor=false">
</script>

<script>

	function initialize()
	{
		
		<c:forEach items="${itinerary.days}" var="day">
		
			<c:forEach items="${day.attractions}" var="attraction">
		
				var mapProp_<c:out value="${attraction.id}" /> = {
						  center:new google.maps.LatLng(<c:out value="${attraction.locationLat}" />,<c:out value="${attraction.locationLong}" />),
						  zoom:14,
						  mapTypeId:google.maps.MapTypeId.ROADMAP
						  };
				
				var map=new google.maps.Map(document.getElementById("googleMap_<c:out value="${attraction.id}" />"),mapProp_<c:out value="${attraction.id}" />);
				
				var marker = new google.maps.Marker({
				      position: new google.maps.LatLng(<c:out value="${attraction.locationLat}" />,<c:out value="${attraction.locationLong}" />),
				      map: map,
				      title: '<c:out value="${attraction.name}" />'
				  });

				
			</c:forEach>
		
		</c:forEach>
	
	}
	
	google.maps.event.addDomListener(window, 'load', initialize);
	

	</script>
	
</head>

<body>

	<div id="main">
	
		<div id="header">
		
			<img src="logo.jpg">
			
			<div id="user-utils">
			
				Login / Register
			
			</div>
		
		</div>
		
		
		<div id="nav-bar">
		
			<ul>

				<li> <a href="home.html">Home </a></li>			
				<li><a href="itineraryBuilder.html">Itineraries </a></li>
				<li> <a href="about.html">About </a></li>

			</ul>
		
		</div>
		
		
		<div id="content">
		
			<div id="itinerary-container">
			
			<c:set var="dayIndex" scope="request" value="1"/>
			
			<c:forEach items="${itinerary.days}" var="day">
			
				<div class="day">
			
					<h4> Day <c:out value="${dayIndex}" /> </h4>
				
					<table>
					
						<tbody>
						
							<c:forEach items="${day.attractions}" var="attraction">  
						
							<!-- start place -->
						
							<tr>
								<td class="time-col">Approx. <br/> <c:out value="${attraction.recommendedTime}" /> Mins </td>								
								<td class="description-col">
								
									
								
									<div class="itinerary-place-detail">
									
										<div class="itinerary-place-heading">
									
											<div class="place-score">
												<span class="score-mark"> <fmt:formatNumber type="number" maxFractionDigits="1" pattern="###.0" value="${attraction.ratingWithRespectToUserPercent}" />% </span>
												MATCH
											</div>
									 
											<h3> <c:out value="${attraction.name}" /> </h3>
											<img src="five-stars.png" height="20px" /><br>
											<span class="place-address"> <c:out value="${attraction.address}" /> </span>
										
										</div>
									
									
										<div class="left-panel">
									
											<div class="place-image">
												<img src="attractionimages/<c:out value="${attraction.imgPath}" />.jpg" height="150px" width="170px">				
											</div>
										
										
											<div class="itinerary-textblock">										

												<div class="badges-block">
												
													<c:forEach items="${attraction.themes}" var="theme">
												
														<span class="badge">  <c:out value="${theme.name}" /> <c:out value="${theme.weight}" /> </span>
													
													</c:forEach>
																										
												</div>
											
											
												<div class="description">
													<c:out value="${attraction.description}" />
												</div>
											
											</div>
											
											<div class="data-panel"> 
												
												<ol class="data-list">
													<li> <span class="data-label"> <img src="transport.png">  </span> <span class="data-value"> <c:out value="${attraction.nearestPublicTrans}" />  </span> </li>
													<li> <span class="data-label"> <img src="price.png">  </span> <span class="data-value"> <c:out value="${attraction.cost}" />  </span> </li>
													<li> <span class="data-label"> <img src="phone.png">  </span> <span class="data-value"> <c:out value="${attraction.contactNo}" />  </span> </li>
												</ol>
											</div>
										
										</div>
										
										<div id="googleMap_<c:out value="${attraction.id}" />" class="googleMap" style="width:300px;height:200px;"></div>
									
									</div>
								
								</td>
							</tr>

							<!-- end place -->

							</c:forEach>
							
						

							
						</tbody>
					
					</table>
				
				</div>	
				
				<c:set var="dayIndex" value="${dayIndex + 1}" />		

			</c:forEach>
				
			</div>

			
			
		
		</div>
		
	</div>

</body>

</html>