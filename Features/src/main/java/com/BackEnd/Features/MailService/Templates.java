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
                "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                "    <title>Registration Confirmation</title>\n" +
                "    <style>\n" +
                "        body {\n" +
                "            font-family: Arial, sans-serif;\n" +
                "            background-color: #f4f4f4;\n" +
                "            margin: 0;\n" +
                "            padding: 0;\n" +
                "        }\n" +
                "        .email-container {\n" +
                "            background-color: #bdbdbd;\n" +
                "            width: 100%;\n" +
                "            max-width: 600px;\n" +
                "            margin: 0 auto;\n" +
                "            padding: 20px;\n" +
                "            border: 1px solid #dddddd;\n" +
                "        }\n" +
                "        .header {\n" +
                "            text-align: center;\n" +
                "            background-color: #8e8e8e;\n" +
                "            color: #ffffff;\n" +
                "            padding: 10px 0;\n" +
                "            display: flex;\n" +
                "        }\n" +
                "        .header h1 {\n" +
                "            margin: 0;\n" +
                "            font-size: 24px;\n" +
                "            padding: 5%;\n" +
                "            font-style: italic;\n" +
                "        }\n" +
                "        .header img{\n" +
                "            margin: auto;\n" +
                "            width: 30%;\n" +
                "            height: 100px;\n" +
                "        }\n" +
                "        .content {\n" +
                "            padding: 20px;\n" +
                "            text-align: center;\n" +
                "        }\n" +
                "        .content h2 {\n" +
                "            color: #080808;\n" +
                "            font-size: 20px;\n" +
                "        }\n" +
                "        .content p {\n" +
                "            font-size: 16px;\n" +
                "            color: #333333;\n" +
                "            line-height: 1.5;\n" +
                "        }\n" +
                "        .image-section {\n" +
                "            display: flex;\n" +
                "            justify-content: center;\n" +
                "            gap: 10px;\n" +
                "            margin: 20px 0;\n" +
                "        }\n" +
                "        .image-section img {\n" +
                "            width: 150px;\n" +
                "            height: auto;\n" +
                "            border-radius: 10px;\n" +
                "            border: 2px solid #dddddd;\n" +
                "        }\n" +
                "        .footer {\n" +
                "            text-align: center;\n" +
                "            margin-top: 20px;\n" +
                "            color: #777777;\n" +
                "            font-size: 12px;\n" +
                "        }\n" +
                "\n" +
                "    </style>\n" +
                "</head>\n" +
                "<body>\n" +
                "    <div class=\"email-container\">\n" +
                "        <div class=\"header\">\n" +
                "            <h1>Welcome to PeoplesMed</h1>\n" +
                "            <img src=\"data:image/png;base64,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\" alt=\"\">\n" +
                "        </div>\n" +
                "        <div class=\"content\">\n" +
                "            <h2>Dear Patient,</h2>\n" +
                "            <p>Thank you for registering with PeoplesMed! We're thrilled to have you join our virtual consultation platform.</p>\n" +
                "            <p>You can now access expert medical advice from the comfort of your home. Our doctors are always here to assist you with any of your healthcare needs.</p>\n" +
                "\n" +
                "            <div class=\"image-section\">\n" +
                "                <img src=\"https://unitedhospitals.com/sites/doctor-consultation1.jpg\" alt=\"Doctor Image\">\n" +
                "                <img src=\"data:image/jpeg;base64,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\" alt=\"Patient Image\">\n" +
                "            </div>\n" +
                "\n" +
                "            <p>If you have any questions, feel free to reach out to our support team. We look forward to providing you with quality healthcare services.</p>\n" +
                "            <p>Best regards,</p>\n" +
                "            <p><strong>The PeoplesMed Team</strong></p>\n" +
                "        </div>\n" +
                "\n" +
                "        <div class=\"footer\">\n" +
                "            <p>&copy; 2024 PeoplesMed Pvt. All rights reserved.</p>\n" +
                "        </div>\n" +
                "    </div>\n" +
                "</body>\n" +
                "</html>\n";
    }
}
