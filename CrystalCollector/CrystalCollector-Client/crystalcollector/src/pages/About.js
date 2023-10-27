import "../styles/about.css";

function About() {
    return (
        <div className="about-page-container">
            <div className="h1-title-container">
                <h1 className="h1-title">About Us</h1>
            </div>
            <div className="about-img-container">
                <img src={"https://crystalcollectorbucket.s3.us-east-2.amazonaws.com/IMG_1740+(2).JPG"} alt="gorgeous creator of crystal collector" />
            </div>
            <div className="about-text-container">
                <p>Here at Crystal Collector</p>
            </div>

        </div>
    )

}

export default About;