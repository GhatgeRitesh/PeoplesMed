package com.BackEnd.Features.MailService;

import com.BackEnd.Features.Models.Doctor;
import org.springframework.stereotype.Component;

@Component
public class Templates {
    private Doctor doc;

    public String RegisertDoc(){
        System.out.println("Template is selected");
        String msg="<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Welcome to PeoplesMed</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f9f9f9;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            background-color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 2px 5px rgba(0, 0, 0, 0.1);\n" +
                "        }\n" +
                "        .email-header {\n" +
                "            text-align: center;\n" +
                "            padding: 20px;\n" +
                "            background-color: #4CAF50;\n" +
                "            color: white;\n" +
                "            border-top-left-radius: 8px;\n" +
                "            border-top-right-radius: 8px;\n" +
                "        }\n" +
                "        .email-header img {\n" +
                "            max-width: 120px;\n" +
                "        }\n" +
                "        .email-body {\n" +
                "            padding: 20px;\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .email-body h1 {\n" +
                "            color: #4CAF50;\n" +
                "            font-size: 24px;\n" +
                "            margin-bottom: 20px;\n" +
                "        }\n" +
                "        .email-body p {\n" +
                "            line-height: 1.6;\n" +
                "        }\n" +
                "        .email-images {\n" +
                "            margin: 20px 0;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .email-images img {\n" +
                "            width: 100%;\n" +
                "            max-width: 400px;\n" +
                "            border-radius: 10px;\n" +
                "            margin: 10px 0;\n" +
                "        }\n" +
                "        .email-footer {\n" +
                "            text-align: center;\n" +
                "            padding: 20px;\n" +
                "            background-color: #f4f4f4;\n" +
                "            border-bottom-left-radius: 8px;\n" +
                "            border-bottom-right-radius: 8px;\n" +
                "            color: #777777;\n" +
                "            font-size: 12px;\n" +
                "        }\n" +
                "        .email-footer a {\n" +
                "            color: #4CAF50;\n" +
                "            text-decoration: none;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <div class=\"email-header\">\n" +
                "            <h1>PeoplesMed</h1>\n" +
                "        </div>\n" +
                "        <div class=\"email-body\">\n" +
                "            <h1>Thank You for Registering!</h1>\n" +
                "            <p>Dear Doctor,</p>\n" +
                "            <p>\n" +
                "                Welcome to <strong>PeoplesMed.pvt</strong>! We are thrilled to have you join our platform. \n" +
                "                Your registration is now complete, and you can start using our services to provide virtual consultations and manage your practice seamlessly.\n" +
                "            </p>\n" +
                "            <p>\n" +
                "                We are here to support you and make sure your experience on PeoplesMed is smooth and beneficial for both you and your patients.\n" +
                "            </p>\n" +
                "            <div class=\"email-images\">\n" +
                "                <img src=\"https://media.istockphoto.com/id/1283312205/photo/concentrated-doctor-working-online-with-a-laptop-sitting-in-a-desk-in-a-consultation.jpg?s=612x612&w=0&k=20&c=PF9Wx6oGJLrua9LmllL4SzrTqhZxAeFgr7-pzxXY0-8=\" alt=\"Doctor-patient virtual consultation\" />\n" +
                "                <img src=\"https://media.istockphoto.com/id/1226933544/photo/happy-family-making-video-call-to-doctor.jpg?s=612x612&w=0&k=20&c=_skavhBzz1ESwvmzkl72kaPWVHflkJhwio8iVPMdgcA=\" alt=\"PeoplesMed platform logo\" />\n" +
                "            </div>\n" +
                "            <p>If you have any questions, feel free to contact our support team.</p>\n" +
                "            <p>Best regards,<br><strong>The PeoplesMed Team</strong></p>\n" +
                "        </div>\n" +
                "        <div class=\"email-footer\">\n" +
                "            <p>&copy; 2024 PeoplesMed.pvt | <a href=\"http://localhost:8083/home/Welcome\">Visit our website</a></p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
        return msg;
    }

    public String RegisterPatient(){
        return "<!DOCTYPE html>\n" +
                "<html lang=\"en\">\n" +
                "<head>\n" +
                "    <meta charset=\"UTF-8\">\n" +
                "    <meta http-equiv=\"X-UA-Compatible\" content=\"IE=edge\">\n" +
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Welcome to PeoplesMed</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            background-color: #ffffff;\n" +
                "            padding: 20px;\n" +
                "            border-radius: 8px;\n" +
                "            box-shadow: 0 4px 8px rgba(0,0,0,0.1);\n" +
                "        }\n" +
                "        .header {\n" +
                "            background-color: #4CAF50;\n" +
                "            padding: 10px;\n" +
                "            color: #ffffff;\n" +
                "            text-align: center;\n" +
                "            border-radius: 8px 8px 0 0;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            margin: 0;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .content h2 {\n" +
                "            color: #333333;\n" +
                "        }\n" +
                "        .content p {\n" +
                "            color: #555555;\n" +
                "        }\n" +
                "        .button {\n" +
                "            display: inline-block;\n" +
                "            background-color: #4CAF50;\n" +
                "            color: #ffffff;\n" +
                "            padding: 10px 20px;\n" +
                "            text-decoration: none;\n" +
                "            border-radius: 5px;\n" +
                "            margin-top: 20px;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            padding: 20px;\n" +
                "            font-size: 12px;\n" +
                "            color: #777777;\n" +
                "        }\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <!-- Email Header -->\n" +
                "        <div class=\"header\">\n" +
                "            <h1>Welcome to PeoplesMed</h1>\n" +
                "        </div>\n" +
                "        \n" +
                "        <!-- Email Content -->\n" +
                "        <div class=\"content\">\n" +
                "            <h2>Congratulations, [User's Name]!</h2>\n" +
                "            <p>You have successfully registered on the <strong>PeoplesMed Application</strong>.</p>\n" +
                "            <p>We are excited to have you as a part of our community. You can now access a wide range of healthcare services, connect with medical professionals, and manage your medical records securely.</p>\n" +
                "            <p>To get started, click the button below to log in and explore the application:</p>\n" +
                "            \n" +
                "            <a href=\"https://www.peoplesmed.com/login\" class=\"button\">Login to PeoplesMed</a>\n" +
                "        </div>\n" +
                "        \n" +
                "        <!-- Email Footer -->\n" +
                "        <div class=\"footer\">\n" +
                "            <p>If you have any questions, feel free to contact our support team at support@peoplesmed.com</p>\n" +
                "            <p>&copy; 2024 PeoplesMed. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
    }
}
