<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8" />
  <title>Emergency Requests</title>
  <style>
    body { font-family: Arial, sans-serif; background-color: #f4f6f8; margin: 0; padding: 20px; }
    .bookcards { max-width: 800px; margin: 0 auto; }
    .patient-card { border: 1px solid #ddd; border-radius: 8px; padding: 16px; margin-bottom: 16px; background: #fff; box-shadow: 0 2px 6px rgba(0,0,0,0.1); }
    .patient-info p { margin: 6px 0; font-size: 15px; }
    .patient-actions { margin-top: 12px; }
    .patient-actions button { margin-right: 8px; padding: 6px 12px; font-size: 13px; border: none; border-radius: 4px; cursor: pointer; }
    .btn.yellow { background: #fdd835; }
    .btn.green  { background: #4caf50; color: white; }
    .btn.red    { background: #f44336; color: white; }
    .status-message { margin-top: 10px; font-weight: bold; font-size: 14px; }
    .accepted   { color: #155724; background-color: #d4edda; padding: 8px; border-radius: 6px; }
    .rejected   { color: #721c24; background-color: #f8d7da; padding: 8px; border-radius: 6px; }
    .pending    { color: #856404; background-color: #fff3cd; padding: 8px; border-radius: 6px; }
  </style>
</head>
<body>

<div class="bookcards">
  <h2>Latest Emergency Requests</h2>
  <hr>
  <div id="cards-container">Loading requests...</div>
</div>

<!-- Preload audio -->
<audio id="newRequestSound" src="/audio/new-request.mp3" preload="auto"></audio>
<audio id="statusUpdateSound" src="/audio/status-update.mp3" preload="auto"></audio>

<script>
  let knownRequestIds = new Set();

  setInterval(fetchRequests, 5000);
  fetchRequests();

  function fetchRequests() {
    fetch('/Hospital/getERequest')
      .then(r => r.json())
      .then(data => {
        const incomingIds = new Set(data.map(r => r.id));
        const newRequests = [...incomingIds].filter(id => !knownRequestIds.has(id));

        if (newRequests.length > 0) {
          document.getElementById("newRequestSound").play();
        }

        knownRequestIds = incomingIds;
        renderCards(data);
      })
      .catch(err => {
        document.getElementById('cards-container').innerHTML = `<p style="color:red">Failed to fetch requests</p>`;
        console.error(err);
      });
  }

  function renderCards(requests) {
    const container = document.getElementById('cards-container');
    container.innerHTML = '';

    if (!requests || requests.length === 0) {
      container.innerHTML = '<p>No emergency requests found.</p>';
      return;
    }

    requests.forEach(req => {
      const card = document.createElement('div');
      card.className = 'patient-card';
      card.id = `card-${req.id}`;

      const ambulanceText = req.ambulanceNeed === true ? 'Yes' :
                            req.ambulanceNeed === false ? 'No' : 'Unknown';

      const statusText = req.acceptanceStatus != null ? req.acceptanceStatus : 'Pending';

      const statusClass = statusText.toLowerCase().includes('accept') ? 'accepted' :
                          statusText.toLowerCase().includes('reject') ? 'rejected' : 'pending';

      card.innerHTML =`
        <div class="patient-info">
          <p><strong>Name:</strong> \${req.name && req.name.trim() !== '' ? req.name : 'N/A'}</p>
          <p><strong>Condition:</strong> \${req.condition && req.condition.trim() !== '' ? req.condition : 'N/A'}</p>
          <p><strong>Type:</strong> \${req.emergencyType && req.emergencyType.trim() !== '' ? req.emergencyType : 'N/A'}</p>
          <p><strong>Address:</strong> \${req.address && req.address.trim() !== '' ? req.address : 'N/A'}, \${req.city && req.city.trim() !== '' ? req.city : 'N/A'}</p>
          <p><strong>Contact:</strong> \${req.contact && req.contact.trim() !== '' ? req.contact : 'N/A'}</p>
          <p><strong>Age:</strong> \${req.age != null ? req.age : 'N/A'}</p>
          <p><strong>Ambulance Needed:</strong> \${ambulanceText}</p>
        </div>
      `;

      const actions = document.createElement('div');
      actions.className = 'patient-actions';

      if (req.acceptanceStatus == null) {
       console.log('Rendering buttons for request:', req);

        const post=req.id;
        console.log(postStatus);
        const Accept="accepted";
        const AcceptAndAmbulance="accepted ambulance";
        const Reject="rejected";


        console.log("Button HTML:", `
          <button onclick="postStatus('${post}', 'accepted')">Accept</button>
        `);

        actions.innerHTML = `
          <button class="btn yellow" onclick="postStatus('${post}', '${Accept}')">Accept</button>
          <button class="btn green" onclick="postStatus('${post}', '${AcceptAndAmbulance}')">Accept & Ambulance</button>
          <button class="btn red" onclick="postStatus('${post}', '${Reject}')">Reject</button>
          <div class="status-message pending" id="status-${req.id}">Status: Pending</div>
        `;

      } else {
        actions.innerHTML =
         ` <div class="status-message ${statusClass}" id="status-${req.id}">Status: ${statusText}</div>
        `;
      }


      card.appendChild(actions);
      container.appendChild(card);
    });
  }

  function postStatus(requestId, status) {
  console.log('Posting status update:', requestId, status);
    fetch('/Hospital/updateRequestStatus', {
      method: 'POST',
      headers: { 'Content-Type': 'application/json' },
      body: JSON.stringify({ requestId, acceptanceStatus: status })
    })
    .then(res => {
      if (!res.ok) throw new Error('Failed to update');
      return res.json();
    })
    .then(() => {
      document.getElementById("statusUpdateSound").play();
      fetchRequests(); // Refresh immediately
    })
    .catch(err => alert('Error updating request: ' + err.message));
  }
</script>
</body>
</html>