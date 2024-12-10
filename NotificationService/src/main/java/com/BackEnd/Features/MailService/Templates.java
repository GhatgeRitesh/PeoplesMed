package com.BackEnd.Features.MailService;

import com.BackEnd.Features.Models.Doctor;
import com.BackEnd.Features.Models.Patient;
import org.springframework.stereotype.Component;

@Component
public class Templates {
    private Doctor doc;

    public String RegisertDoc(Doctor doc) {
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Welcome to PeoplesMed.pvt</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: 'Arial', sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            background-color: #ffffff;\n" +
                "            width: 90%;\n" +
                "            max-width: 600px;\n" +
                "            margin: 20px auto;\n" +
                "            border-radius: 8px;\n" +
                "            overflow: hidden;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #007bff;\n" +
                "            color: #ffffff;\n" +
                "            text-align: center;\n" +
                "            padding: 20px 10px;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            margin: 0;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        .content p {\n" +
                "            font-size: 16px;\n" +
                "            line-height: 1.6;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .content .details {\n" +
                "            margin-top: 20px;\n" +
                "            padding: 15px;\n" +
                "            background-color: #f9f9f9;\n" +
                "            border-left: 5px solid #007bff;\n" +
                "            border-radius: 5px;\n" +
                "        }\n" +
                "        .content .details p {\n" +
                "            margin: 8px 0;\n" +
                "        }\n" +
                "        .cta-button {\n" +
                "            display: inline-block;\n" +
                "            margin-top: 20px;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #007bff;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            font-size: 16px;\n" +
                "            border-radius: 5px;\n" +
                "            box-shadow: 0 2px 4px rgba(0, 0, 0, 0.2);\n" +
                "            transition: background-color 0.3s ease;\n" +
                "        }\n" +
                "        .cta-button:hover {\n" +
                "            background-color: #0056b3;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #888888;\n" +
                "            font-size: 12px;\n" +
                "            border-top: 1px solid #eaeaea;\n" +
                "        }\n" +
                "        .footer a {\n" +
                "            color: #007bff;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <!-- Header -->\n" +
                "        <div class=\"header\">\n" +
                "            <h1>Welcome to PeoplesMed.pvt!</h1>\n" +
                "            <p>Your journey to better healthcare starts here.</p>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Content -->\n" +
                "        <div class=\"content\">\n" +
                "            <p>Dear <strong>" + doc.getName() + "</strong>,</p>\n" +
                "            <p>We are thrilled to welcome you to the <strong>PeoplesMed.pvt</strong> platform. Here's a summary of your registration details:</p>\n" +
                "\n" +
                "            <div class=\"details\">\n" +
                "                <p><strong>Name:</strong> " + doc.getName() + "</p>\n" +
                "                <p><strong>Specialization:</strong> " + doc.getSpecialization() + "</p>\n" +
                "                <p><strong>Hospital Name:</strong> " + doc.getHospitalName() + "</p>\n" +
                "                <p><strong>City:</strong>" + doc.getCity() + "</p>\n" +
                "                <p><strong>Contact:</strong>" + doc.getContact() + "</p>\n" +
                "                <p><strong>Email:</strong>" + doc.getEmail() + "</p>\n" +
                "            </div>\n" +
                "\n" +
                "            <p>As a member of our platform, you gain access to the following benefits:</p>\n" +
                "            <ul>\n" +
                "                <li>Connect with patients effortlessly.</li>\n" +
                "                <li>Secure and efficient communication tools.</li>\n" +
                "                <li>Manage your appointments with ease.</li>\n" +
                "            </ul>\n" +
                "\n" +
                "            <p>Get started by visiting your dashboard and exploring all the tools available to you.</p>\n" +
                "\n" +
                "            <!-- Call to Action Button -->\n" +
                "            <a href=\"http://localhost:8083/login\" class=\"cta-button\">Go to Dashboard</a>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Footer -->\n" +
                "        <div class=\"footer\">\n" +
                "            <p>Need help? Visit our <a href=\"http://localhost:8083/support\">Support Center</a> or contact us at support@peoplesmed.com.</p>\n" +
                "            <p>© 2024 PeoplesMed.pvt. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
    }

     public String RegisterPatient(String Name){
      return "<!DOCTYPE html>\n" +
              "<html lang=\"en\">\n" +
              "<head>\n" +
              "    <meta charset=\"UTF-8\">\n" +
              "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
              "    <title>Welcome to [Your Healthcare Service]</title>\n" +
              "    <style>\n" +
              "        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&family=Merriweather:wght@400;700&display=swap');\n" +
              "\n" +
              "        body {\n" +
              "            font-family: 'Roboto', Arial, sans-serif;\n" +
              "            margin: 0;\n" +
              "            padding: 0;\n" +
              "            background-color: #f9f9f9;\n" +
              "        }\n" +
              "        .email-container {\n" +
              "            max-width: 800px;\n" +
              "            margin: 20px auto;\n" +
              "            background: #ffffff;\n" +
              "            border-radius: 8px;\n" +
              "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
              "            overflow: hidden;\n" +
              "            border: 1px solid #e1e1e1;\n" +
              "        }\n" +
              "        .email-header {\n" +
              "            background-color: #003366;\n" +
              "            color: #ffffff;\n" +
              "            text-align: center;\n" +
              "            padding: 30px 20px;\n" +
              "        }\n" +
              "        .email-header h1 {\n" +
              "            margin: 0;\n" +
              "            font-size: 32px;\n" +
              "            font-family: 'Merriweather', serif;\n" +
              "            font-weight: 700;\n" +
              "        }\n" +
              "        .email-body {\n" +
              "            padding: 25px;\n" +
              "            color: #333333;\n" +
              "            line-height: 1.8;\n" +
              "        }\n" +
              "        .email-body h2 {\n" +
              "            margin-top: 0;\n" +
              "            color: #003366;\n" +
              "            font-size: 24px;\n" +
              "            font-family: 'Merriweather', serif;\n" +
              "            font-weight: 700;\n" +
              "        }\n" +
              "        .email-body p {\n" +
              "            margin: 15px 0;\n" +
              "            font-size: 16px;\n" +
              "        }\n" +
              "        .email-body ul {\n" +
              "            list-style: disc;\n" +
              "            margin: 10px 0 20px 20px;\n" +
              "            padding: 0;\n" +
              "            color: #555555;\n" +
              "        }\n" +
              "        .email-body a {\n" +
              "            color: #0056b3;\n" +
              "            text-decoration: underline;\n" +
              "        }\n" +
              "        .button {\n" +
              "            display: inline-block;\n" +
              "            margin: 20px 0;\n" +
              "            padding: 14px 28px;\n" +
              "            background-color: #28a745;\n" +
              "            color: #ffffff;\n" +
              "            border-radius: 5px;\n" +
              "            text-decoration: none;\n" +
              "            font-size: 18px;\n" +
              "            font-weight: 500;\n" +
              "            font-family: 'Roboto', Arial, sans-serif;\n" +
              "        }\n" +
              "        .button:hover {\n" +
              "            background-color: #218838;\n" +
              "        }\n" +
              "        .email-footer {\n" +
              "            background-color: #f4f4f4;\n" +
              "            text-align: center;\n" +
              "            padding: 15px 20px;\n" +
              "            font-size: 14px;\n" +
              "            color: #666666;\n" +
              "            border-top: 1px solid #e1e1e1;\n" +
              "        }\n" +
              "        .email-footer p {\n" +
              "            margin: 5px 0;\n" +
              "        }\n" +
              "        .email-images {\n" +
              "            display: flex;\n" +
              "            justify-content: center;\n" +
              "            align-items: center;\n" +
              "            gap: 15px;\n" +
              "            margin: 20px 0;\n" +
              "        }\n" +
              "        .email-images img {\n" +
              "            max-width: 100%;\n" +
              "            height: auto;\n" +
              "            border-radius: 8px;\n" +
              "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
              "        }\n" +
              "    </style>\n" +
              "</head>\n" +
              "<body>\n" +
              "    <div class=\"email-container\">\n" +
              "        <!-- Header Section -->\n" +
              "        <div class=\"email-header\">\n" +
              "            <h1>Welcome to PeoplesMed</h1>\n" +
              "        </div>\n" +
              "\n" +
              "        <!-- Body Section -->\n" +
              "        <div class=\"email-body\">\n" +
              "            <h2>Dear "+Name+",</h2>\n" +
              "            <p>\n" +
              "                Welcome to our healthcare platform! We're thrilled to have you onboard \n" +
              "                as part of our community that prioritizes your health and well-being.\n" +
              "            </p>\n" +
              "\n" +
              "            <!-- Images Section -->\n" +
              "            <div class=\"email-images\">\n" +
              "                <img src=\"https://via.placeholder.com/350x150?text=Healthcare+Banner\" alt=\"Healthcare Banner\">\n" +
              "                <img src=\"https://via.placeholder.com/350x150?text=Wellness+Services\" alt=\"Wellness Services\">\n" +
              "            </div>\n" +
              "\n" +
              "            <p>\n" +
              "                Here's what you can now explore as a registered member:\n" +
              "            </p>\n" +
              "            <ul>\n" +
              "                <li>Book appointments with top-rated doctors quickly and easily.</li>\n" +
              "                <li>Track and manage your health records securely.</li>\n" +
              "                <li>Receive personalized wellness recommendations.</li>\n" +
              "                <li>Stay updated with our health blog and new services.</li>\n" +
              "            </ul>\n" +
              "\n" +
              "            <p>\n" +
              "                To get started, click the button below to access your account:\n" +
              "            </p>\n" +
              "\n" +
              "            <a href=\"http://localhost:8083/home/Welcome\" class=\"button\">Go to My Account</a>\n" +
              "\n" +
              "            <p>\n" +
              "                Have any questions? Reach out to our support team at \n" +
              "                <a href=\"mailto:support@yourdomain.com\">support@yourdomain.com</a>. \n" +
              "            </p>\n" +
              "\n" +
              "            <p>\n" +
              "                Thank you for trusting us as your healthcare partner. Together, let’s achieve your wellness goals.\n" +
              "            </p>\n" +
              "\n" +
              "            <p style=\"margin: 20px 0 0; font-style: italic;\">\n" +
              "                Best regards,<br>\n" +
              "                The PeoplesMed Onboarding Team\n" +
              "            </p>\n" +
              "        </div>\n" +
              "\n" +
              "        <!-- Footer Section -->\n" +
              "        <div class=\"email-footer\">\n" +
              "            <p>\n" +
              "                This email is brought to you by [Your Healthcare Service]. If you’re receiving it in error, please ignore it. <br>\n" +
              "                © 2024 PeoplesMed.pvt. All rights reserved.\n" +
              "            </p>\n" +
              "        </div>\n" +
              "    </div>\n" +
              "</body>\n" +
              "</html>\n";
     }


     public String MeetingDetailsPatientMail(MeetingDetails meetingDetails){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Meeting Details</title>\n" +
                "    <style>\n" +
                "        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');\n" +
                "\n" +
                "        body {\n" +
                "            font-family: 'Roboto', Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #f9f9f9;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 20px auto;\n" +
                "            background: #ffffff;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "            border: 1px solid #e1e1e1;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .email-header {\n" +
                "            background-color: #003366;\n" +
                "            color: #ffffff;\n" +
                "            text-align: center;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        .email-header h1 {\n" +
                "            margin: 0;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "        .email-body {\n" +
                "            padding: 20px;\n" +
                "            color: #333333;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .email-body h2 {\n" +
                "            margin-top: 0;\n" +
                "            color: #003366;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "        .email-body p {\n" +
                "            margin: 10px 0;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "        .email-body table {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "            margin: 20px 0;\n" +
                "        }\n" +
                "        .email-body table th,\n" +
                "        .email-body table td {\n" +
                "            text-align: left;\n" +
                "            padding: 12px;\n" +
                "            border: 1px solid #e1e1e1;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "        .email-body table th {\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .email-body .join-button {\n" +
                "            display: inline-block;\n" +
                "            margin: 20px 0;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #28a745;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "        .email-body .join-button:hover {\n" +
                "            background-color: #218838;\n" +
                "        }\n" +
                "        .email-footer {\n" +
                "            background-color: #f4f4f4;\n" +
                "            text-align: center;\n" +
                "            padding: 15px 20px;\n" +
                "            font-size: 14px;\n" +
                "            color: #666666;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <!-- Header -->\n" +
                "        <div class=\"email-header\">\n" +
                "            <h1>Meeting Details</h1>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Body -->\n" +
                "        <div class=\"email-body\">\n" +
                "            <h2>Dear User ,</h2>\n" +
                "            <p>Below are the details of your scheduled meeting: with Doctor</p><h1>\n" + meetingDetails.getDname() +
                "            </h1><table>\n" +
                "                <tr>\n" +
                "                    <th>Meeting ID</th>\n" +
                "                    <td>"+meetingDetails.getId()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>Topic</th>\n" +
                "                    <td>"+meetingDetails.getTopic()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>Start Time</th>\n" +
                "                    <td>"+meetingDetails.getStart_time()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>Duration</th>\n" +
                "                    <td>"+meetingDetails.getDuration()+"minutes</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>UUID</th>\n" +
                "                    <td>"+meetingDetails.getUuid()+"</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "            <p>Click the button below to join the meeting:</p>\n" +
                "            <a href=\""+meetingDetails.getJoin_url()+"\" class=\"join-button\">Join Meeting</a>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Footer -->\n" +
                "        <div class=\"email-footer\">\n" +
                "            <p>\n" +
                "                If you have any questions or face issues joining the meeting, feel free to contact us at \n" +
                "                <a href=\"mailto:support@yourdomain.com\">support@yourdomain.com</a>.\n" +
                "            </p>\n" +
                "            <p>© 2024 PeoplesMed. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
     }
    public String MeetingDetailsDoctorMail(MeetingDetails meetingDetails){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Meeting Details</title>\n" +
                "    <style>\n" +
                "        @import url('https://fonts.googleapis.com/css2?family=Roboto:wght@400;500;700&display=swap');\n" +
                "\n" +
                "        body {\n" +
                "            font-family: 'Roboto', Arial, sans-serif;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "            background-color: #f9f9f9;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 20px auto;\n" +
                "            background: #ffffff;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);\n" +
                "            border: 1px solid #e1e1e1;\n" +
                "            overflow: hidden;\n" +
                "        }\n" +
                "        .email-header {\n" +
                "            background-color: #003366;\n" +
                "            color: #ffffff;\n" +
                "            text-align: center;\n" +
                "            padding: 20px;\n" +
                "        }\n" +
                "        .email-header h1 {\n" +
                "            margin: 0;\n" +
                "            font-size: 24px;\n" +
                "        }\n" +
                "        .email-body {\n" +
                "            padding: 20px;\n" +
                "            color: #333333;\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .email-body h2 {\n" +
                "            margin-top: 0;\n" +
                "            color: #003366;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "        .email-body p {\n" +
                "            margin: 10px 0;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "        .email-body table {\n" +
                "            width: 100%;\n" +
                "            border-collapse: collapse;\n" +
                "            margin: 20px 0;\n" +
                "        }\n" +
                "        .email-body table th,\n" +
                "        .email-body table td {\n" +
                "            text-align: left;\n" +
                "            padding: 12px;\n" +
                "            border: 1px solid #e1e1e1;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "        .email-body table th {\n" +
                "            background-color: #f4f4f4;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .email-body .join-button {\n" +
                "            display: inline-block;\n" +
                "            margin: 20px 0;\n" +
                "            padding: 10px 20px;\n" +
                "            background-color: #28a745;\n" +
                "            color: #ffffff;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "            font-size: 16px;\n" +
                "        }\n" +
                "        .email-body .join-button:hover {\n" +
                "            background-color: #218838;\n" +
                "        }\n" +
                "        .email-footer {\n" +
                "            background-color: #f4f4f4;\n" +
                "            text-align: center;\n" +
                "            padding: 15px 20px;\n" +
                "            font-size: 14px;\n" +
                "            color: #666666;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <!-- Header -->\n" +
                "        <div class=\"email-header\">\n" +
                "            <h1>Meeting Details</h1>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Body -->\n" +
                "        <div class=\"email-body\">\n" +
                "            <h2>Dear Doctor,</h2>\n" +
                "            <p>Below are the details of your scheduled meeting: with Patient</p><h1>\n" + meetingDetails.getPname() +
                "            <table></h1>\n" +
                "                <tr>\n" +
                "                    <th>Meeting ID</th>\n" +
                "                    <td>"+meetingDetails.getId()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>Topic</th>\n" +
                "                    <td>"+meetingDetails.getTopic()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>Start Time</th>\n" +
                "                    <td>"+meetingDetails.getStart_time()+"</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>Duration</th>\n" +
                "                    <td>"+meetingDetails.getDuration()+"minutes</td>\n" +
                "                </tr>\n" +
                "                <tr>\n" +
                "                    <th>UUID</th>\n" +
                "                    <td>"+meetingDetails.getUuid()+"</td>\n" +
                "                </tr>\n" +
                "            </table>\n" +
                "            <p>Click the button below to join the meeting:</p>\n" +
                "            <a href=\""+meetingDetails.getJoin_url()+"\" class=\"join-button\">Join Meeting</a>\n" +
                "        </div>\n" +
                "\n" +
                "        <!-- Footer -->\n" +
                "        <div class=\"email-footer\">\n" +
                "            <p>\n" +
                "                If you have any questions or face issues joining the meeting, feel free to contact us at \n" +
                "                <a href=\"mailto:support@yourdomain.com\">support@yourdomain.com</a>.\n" +
                "            </p>\n" +
                "            <p>© 2024 PeoplesMed. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
    }
}