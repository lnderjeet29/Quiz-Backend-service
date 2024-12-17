<h1>Quiz Backend - REST API Controllers</h1>
<p>
    Welcome to <strong>Quiz Backend</strong>, a backend service built using <strong>Spring Boot</strong> with <strong>Java</strong>,
    designed to manage quiz sessions, questions, and user performance. This repository contains the REST controllers
    for managing the core application features like quiz management and performance tracking.
</p>

<hr />

<h2>🚀 Features</h2>
<ul>
    <li>Quiz session management with total questions and correct answers tracking.</li>
    <li>Question management including creation, retrieval, and random selection.</li>
    <li>Performance tracking with the ability to submit answers and calculate correct answers.</li>
    <li>Standardized error handling with meaningful response messages.</li>
</ul>

<hr />

<h2>📂 API Endpoints</h2>

<h3>1. <strong>Start Quiz</strong></h3>
<p>Starts a new quiz session for the user.</p>
<h4>Endpoint:</h4>
<ul>
    <li>
        <strong>POST /api/quiz/start</strong><br />
        Starts a new quiz session.
        <ul>
            <li>Request Parameter: <code>userId</code> - The ID of the user starting the quiz.</li>
            <li>Response:
                <ul>
                    <li><code>200 OK</code>: Returns the <code>quizSessionId</code> for the session.</li>
                </ul>
            </li>
        </ul>
    </li>
</ul>

<h3>2. <strong>Get Quiz Questions</strong></h3>
<p>Fetches a shuffled list of questions for the specified session.</p>
<h4>Endpoint:</h4>
<ul>
    <li>
        <strong>GET /api/quiz/questions</strong><br />
        Retrieves a list of random quiz questions for a session.
        <ul>
            <li>Request Parameter: <code>sessionId</code> - The ID of the quiz session to fetch questions for.</li>
            <li>Response:
                <ul>
                    <li><code>200 OK</code>: Returns a list of shuffled questions.</li>
                    <li><code>404 Not Found</code>: If the session is invalid or not found.</li>
                </ul>
            </li>
        </ul>
    </li>
</ul>
<h4>Response of Random Question list API</h4>
<img src="https://github.com/user-attachments/assets/f4673cdf-2637-46d7-9be9-d4fee0177b0f"  width="600" height="400"/>

<h3>3. <strong>Submit Answer</strong></h3>
<p>Submits an answer for a specific question in the quiz session.</p>
<h4>Endpoint:</h4>
<ul>
    <li>
        <strong>POST /api/quiz/answer</strong><br />
        Submits the selected answer for a quiz question.
        <ul>
            <li>Request Parameters:
                <ul>
                    <li><code>quizSessionId</code> - The ID of the quiz session.</li>
                    <li><code>questionId</code> - The ID of the question being answered.</li>
                    <li><code>selectedOption</code> - The option selected by the user (e.g., "a", "b", "c", or "d").</li>
                </ul>
            </li>
            <li>Response:
                <ul>
                    <li><code>204 No Content</code>: Successfully submitted the answer.</li>
                </ul>
            </li>
        </ul>
    </li>
</ul>

<h3>4. <strong>Get User Performance</strong></h3>
<p>Fetches the performance details for a specific quiz session, including the number of correct answers and total questions.</p>
<h4>Endpoint:</h4>
<ul>
    <li>
        <strong>GET /api/quiz/performance</strong><br />
        Retrieves the performance details for a user’s quiz session.
        <ul>
            <li>Request Parameter: <code>quizSessionId</code> - The ID of the quiz session for which the performance is requested.</li>
            <li>Response:
                <ul>
                    <li><code>200 OK</code>: Returns the performance data including the number of correct answers and total questions answered.</li>
                </ul>
            </li>
        </ul>
    </li>
</ul>
<h4>Response of Performance API</h4>
<img src="https://github.com/user-attachments/assets/65988951-596c-4b18-bd8c-dc81c30757be"  width="600" height="400"/>
<hr />
<h2>Using H2 DB</h2>
<img src="https://github.com/user-attachments/assets/082f993c-62a4-4e15-88d4-045d65c2967a"  width="300" height="200"/>

<h2>💬 Contact</h2>
<p>Feel free to reach out for any questions or contributions:</p>
<ul>
    <li>Email: <a href="mailto:inderjeetdev33@example.com">inderjeetdev33@example.com</a></li>
    <li>GitHub: <a href="https://github.com/inderjeet29">https://github.com/inderjeet29</a></li>
</ul>
