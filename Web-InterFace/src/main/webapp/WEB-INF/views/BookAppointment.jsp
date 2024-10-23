<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>DoctorSpecialization</title>
    <link rel="stylesheet" href="/css/BookAppointment.css">
</head>
<body>
    
  <form action="">

    <br> <br> <br> <br> <br>
    <div class="div_details">
        <div class="div_cntainer">

            <div class="div_left">
                <br>
                
                 <div class="div_name">
                    <label for="name">Dr.John Doe</label>
                 </div>

                 <br>
                 <div class="div_card">
                      <div class="div_im_sms">
                          <div class="div_img">
                            <!-- <img src="/images/dr1.jpg" alt=""> -->
                             <img src="https://png.pngtree.com/png-vector/20240127/ourlarge/pngtree-doctor-png-png-image-png-free-png-ai-generative-png-image_11555707.png" alt="">
                          </div>
                          <br> 
                          <div class="sms">
                           <a href="#"> <button> <h4>SMS Todgdfgsd </h4> </button></a></div>
                      </div>

                       <div class="div_Container_Spec">
                      <div class="div_specialization">
                          <h1>Specialization</h1> 
                           <span>Cosmatic Surgery</span>
                           <span>Reconstructive Microsurgery</span>
                      </div>

                      <div class="div_Primer">
                        <h1>Primary Consultation Location</h1> 
                        <span>Manipal Hospitals(Old Airport Road)</span>
                      </div>

                    </div>

                 </div>
                 
       <br> <br>


               <div class="Doctor_bio">
                <h2>Quick Bio</h2>
                <br>
                  <p>The first person to document a surgery was the 6th century BC Indian physician-surgeon, Sushruta. He specialized in cosmetic plastic surgery and even documented an open rhinoplasty procedure.[3] His magnum opus Suśruta-saṃhitā is one of the most important surviving ancient treatises on medicine and is considered a foundational text of both Ayurveda and surgery. The treatise addresses all aspects of general medicine, but the translator G. D. Singhal dubbed Sushruta "the father of surgical intervention" on account. </p>
               </div>
               <br>
               <hr><hr><hr>


               <div class="hospital">
                 <img src="https://www.moh.gov.et/sites/default/files/styles/large/public/2021-04/medicalservice.jpg?itok=cGkSlaj9" alt="">              
                 </div>
            </div>


            <div class="div_right">
              <div class="Apt_book">
                <h1>My Weekly Schedule</h1>
                   <div class="Apt_book_Hsc">
                    <p>Main Hospitals,old Airport Road</p>
                      <div class="Apt_book_time">
                         <div class="div_spn"><span >09:00AM - 03:00PM</span></div>
                          <div class="div_day">
                          <div class="day">MON</div>
                          <div class="day">WED</div>
                        </div>
                      </div>
                   </div>


                   <div class="Apt_book_Hsc">
                    <p>Clinic Name , Pune Clinic</p>
                      <div class="Apt_book_time">
                         <div class="div_spn"><span >10:30AM - 12:00PM</span></div>
                          <div class="div_day">
                          <div class="day">MON</div>
                          <div class="day">SAT</div>
                        </div>
                      </div>
                   </div>

                  

                   <div class="Apt_book_Hsc">
                    <p>Home Clinic,Pune</p>
                      <div class="Apt_book_time">
                         <div class="div_spn"><span >05:00PM - 08:00PM</span></div>
                          <div class="div_day">
                          <div class="day">MON-SAT</div>
                          
                        </div>
                      </div>
                    </div>
                     
                    <br> <br> <br>

       <!-- Book Schedule ............. -->
                
         
      







       <div class="Book_Schedul">
         <h1>Book Appointment</h1>
         <div class="Book_div1">
             
           
          <!--  -->

        
            <label for="username">Name:</label>
            <input type="text" id="username" name="username" required>
    
            <label for="email">Email:</label>
            <input type="email" id="email" name="email" required>

            <label for="reason">Reason for Appointment:</label>
            <textarea id="reason" name="reason" placeholder="Describe your symptoms or reason for visit" required></textarea>

           <br>
             
          <!-- <button id="myButton2" class="unclicked" onclick="changeColor(2)">10:00AM</button>
          <button id="myButton3" class="unclicked" onclick="changeColor(3)">11:00AM</button>
          <button id="myButton4" class="unclicked" onclick="changeColor(4)">12:00PM</button>
          <button id="myButton5" class="unclicked" onclick="changeColor(5)">01:00PM</button>
          <button id="myButton6" class="unclicked" onclick="changeColor(6)">02:00PM</button>
          <button id="myButton7" class="unclicked" onclick="changeColor(7)">03:00PM</button>
          <button id="myButton8" class="unclicked" onclick="changeColor(8)">04:00PM</button>
          <button id="myButton9" class="unclicked" onclick="changeColor(9)">05:00PM</button>
          <br><br>
          <button class="submit">Submit</button> -->


          <div class="form-group">
            <label for="timing">Selected Time</label>
            <input type="text" id="timing" name="timing" readonly>
        </div>

        <div class="time-buttons">
            <button type="button" onclick="selectTime(this, '1 PM')">1 PM</button>
            <button type="button" onclick="selectTime(this, '2 PM')">2 PM</button>
            <button type="button" onclick="selectTime(this, '3 PM')">3 PM</button>
            <button type="button" onclick="selectTime(this, '4 PM')">4 PM</button>
            <button type="button" onclick="selectTime(this, '5 PM')">5 PM</button>
            <button type="button" onclick="selectTime(this, '6 PM')">6 PM</button>
        </div>


 
        <div class="button-group">
          <button type="button" class="button-primary">Submit</button>

          <div class="available">
          <div class="dot1"></div> <span>Alloted</span> 
          <div class="dot2"></div><span>Available</span>
        </div>

      </div>


         </div>

       </div>



              </div>
            </div>
        </div>
    </div>
   
    <br> <br> <br> <br>
  
  </form>

    <script>
   function selectTime(button, time) {
    const buttons = document.querySelectorAll('.time-buttons button');
    buttons.forEach(btn => btn.classList.remove('selected'));
    button.classList.add('selected');
    document.getElementById('timing').value = time;
}
    </script>
</body>
</html>