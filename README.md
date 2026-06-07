
<body>
<h1>The Hogwarts Sorting Hat: An Interactive Personality Quiz</h1>

<h2>1. Title</h2>
<p><strong>The Hogwarts Sorting Hat: An Interactive Personality Quiz</strong></p>

    <h2>2. Introduction / Problem Statement</h2>
    <ul>
        <li>
            <strong>Overview:</strong>  
            This project is a fun, interactive personality quiz that brings the “Sorting Hat” experience from Harry Potter to life by placing users into one of the four legendary houses: Gryffindor, Hufflepuff, Ravenclaw, or Slytherin.
        </li>
        <li>
            <strong>Problem Statement:</strong>  
            Most basic quizzes available online are boring and do not save user results after closing the application.
        </li>
        <li>
            <strong>Relevance:</strong>  
            This project solves that problem by introducing an engaging visual layout and a memory system that remembers users and their assigned houses. It demonstrates how real-world software handles both logic and persistent data storage.
        </li>
    </ul>

    <h2>3. Objectives</h2>
    <ul>
        <li>To design a smooth, user-friendly Java application with a visual interface.</li>
        <li>To build a smart scoring system that matches a user’s personality to the correct house.</li>
        <li>To allow users to save their results, view history, and update or delete records.</li>
    </ul>

    <h2>4. Technologies / Frameworks</h2>
    <ul>
        <li>
            <strong>Language:</strong> Java  
            <ul>
                <li>Reason: Java is the required language for our OOP course and is ideal for structured backend logic.</li>
            </ul>
        </li>
        <li>
            <strong>GUI Framework:</strong> Swing  
            <ul>
                <li>
                    Reason: Swing is a mature, lightweight framework included with the Java Development Kit (JDK), ensuring compatibility and easy setup without external dependencies like JavaFX.
                </li>
            </ul>
        </li>
    </ul>

    <h2>5. Features</h2>
    <ul>
        <li><strong>User Registration:</strong> Users enter their name and details before starting the quiz.</li>
        <li><strong>Sorting Quiz:</strong> Multiple-choice questions calculate the user’s house based on answers.</li>
        <li><strong>Result Screen:</strong> Displays the assigned house along with its description and signature colors.</li>
        <li><strong>History Dashboard:</strong> Allows users to view past results, edit profile names, or clear history.</li>
    </ul>

    <h2>6. Design &amp; User Interaction</h2>
    <ul>
        <li>
            <strong>User Flow:</strong>  
            The user opens the app, enters their name, answers quiz questions, and receives their house result. A history page is available to view previous results.
        </li>
        <li>
            <strong>Layout:</strong>  
            A clean, centralized window layout with a dark theme to match the magical atmosphere.
        </li>
    </ul>

    <h2>7. Implementation Details (OOP Pillars)</h2>
    <p>This project uses all four core Object-Oriented Programming principles:</p>
    <ul>
        <li>
            <strong>Encapsulation:</strong>  
            Variables are kept private inside classes (e.g., User, Question) and accessed using public getter and setter methods.
        </li>
        <li>
            <strong>Inheritance:</strong>  
            A base House class is created, with Gryffindor, Hufflepuff, Ravenclaw, and Slytherin inheriting common behavior while defining unique traits.
        </li>
        <li>
            <strong>Polymorphism:</strong>  
            Method overriding is used so methods like <code>displayTraits()</code> behave differently for each house.
        </li>
        <li>
            <strong>Abstraction:</strong>  
            Interfaces or abstract classes hide complex scoring logic from the main user interface.
        </li>
    </ul>

    <h2>8. Validation and Error Handling</h2>
    <ul>
        <li>
            <strong>Validation:</strong>  
            Ensures required fields (such as username) are not left empty.
        </li>
        <li>
            <strong>Error Handling:</strong>  
            Uses try-catch blocks to prevent crashes due to missing files or invalid inputs.
        </li>
    </ul>

    <h2>9. File Handling</h2>
    <ul>
        <li>
            <strong>How it Works:</strong>  
            Java’s built-in file readers and writers are used for data management.
        </li>
        <li>
            <strong>Data Storage:</strong>  
            User details and assigned houses are stored in a local text file.
        </li>
        <li>
            <strong>Operations:</strong>  
            Supports full CRUD operations (Create, Read, Update, Delete).
        </li>
    </ul>

    <h2>10. Timeline &amp; Milestones</h2>
    <ul>
        <li>
            <strong>Week 1 (Design):</strong>  
            Application design, question writing, and core Java logic development.
        </li>
        <li>
            <strong>Core Coding:</strong>  
            Implementation of OOP structures and main application logic.
        </li>
        <li>
            <strong>Week 2 (GUI &amp; Files):</strong>  
            GUI development, file storage integration, and testing.
        </li>
        <li>
            <strong>Testing &amp; Final Touch:</strong>  
            Bug fixing, input testing, and user manual creation.
        </li>
    </ul>

    <h2>11. Resources Required</h2>
    <ul>
        <li><strong>Hardware:</strong> A standard laptop.</li>
        <li><strong>Software:</strong> JDK 17+, IntelliJ IDEA or Eclipse IDE.</li>
    </ul>

    <h2>12. Conclusion</h2>
    <p>
        The Hogwarts Sorting Hat Simulator is more than just a quiz—it is a complete Java application that demonstrates the practical use of OOP concepts, GUI design, and file handling. The project fulfills all academic requirements while remaining engaging and user-friendly.
    </p>

    <h2>13. References</h2>
    <ul>
        <li>Oracle Java Documentation (File I/O and Swing GUI).</li>
    </ul>

</body>
</html>
