import FirstComponent, { FifthComponent } from './FirstComponent';
import FourthComponent from './FourthComponent';
import LearningJavaScript from './LearningJavaScript';

export default function LearningComponent() {
    return (
        <div className="App">
            <FirstComponent />
            <FourthComponent />
            <FifthComponent />
            <LearningJavaScript />
        </div>
    );
}
