import "./App.css";
import { BrowserRouter, Routes, Route } from "react-router-dom";
import Header from "./components/Header";
import Footer from "./components/Footer";
import ArticleList from "./components/ArticleList";
import ArticleCreate from "./components/ArticleCreate";

function App() {
  return (
    <BrowserRouter>
      <Header />
      {/* Routes 바깥에는 Route 쓸 수 없음, 고정되는 파일은 파일이름으로만 */}
      <Routes>
        <Route path="/" element={<ArticleList />} />
        <Route path="/create-article/:id" element={<ArticleCreate />} />
        {/* id = /add 가 될 수도 있고 1, 2 가 들어갈 수도 있음 */}
        {/* add가 오면 추가 숫자가 오면 수정 */}
      </Routes>

      <Footer />
    </BrowserRouter>
  );
}

export default App;
