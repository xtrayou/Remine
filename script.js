// Book Data
const booksData = [
    {
        id: 1,
        title: "The Psychology of Money",
        author: "Morgan Housel",
        cover: "assets/book-psychology.jpg",
        price: "Free",
        rating: 4.8,
        description: "Doing well with money isn't necessarily about what you know. It's about how you behave. And behavior is hard to teach, even to really smart people. The Psychology of Money is an essential read for anyone interested in being better with money. Fast-paced and engaging, this book will teach you how to have a better relationship with money and to make smarter financial decisions."
    },
    {
        id: 2,
        title: "The 7 Habits of Highly Effective People",
        author: "Stephen R. Covey",
        cover: "assets/book-7habits.jpg",
        price: "$9.99",
        rating: 4.7,
        description: "One of the most inspiring and impactful books ever written, The 7 Habits of Highly Effective People has captivated readers for 25 years. It has transformed the lives of presidents and CEOs, educators and parents—in short, millions of people of all ages and occupations."
    },
    {
        id: 3,
        title: "The Alchemist",
        author: "Paulo Coelho",
        cover: "assets/book-alchemist.jpg",
        price: "$8.99",
        rating: 4.6,
        description: "Paulo Coelho's enchanting novel has inspired a devoted following around the world. This story, dazzling in its powerful simplicity and inspiring wisdom, is about an Andalusian shepherd boy named Santiago who travels from his homeland in Spain to the Egyptian desert in search of a treasure buried near the Pyramids."
    },
    {
        id: 4,
        title: "Ikigai",
        author: "Héctor García",
        cover: "assets/book-ikigai.jpg",
        price: "$7.99",
        rating: 4.5,
        description: "According to the Japanese, everyone has an ikigai—a reason for living. And according to the residents of the Japanese village with the world's longest-living people, finding it is the key to a happier and longer life."
    },
    {
        id: 5,
        title: "Rich Dad Poor Dad",
        author: "Robert Kiyosaki",
        cover: "assets/book-richdad.jpg",
        price: "$10.99",
        rating: 4.7,
        description: "Rich Dad Poor Dad is Robert's story of growing up with two dads — his real father and the father of his best friend, his rich dad — and the ways in which both men shaped his thoughts about money and investing."
    },
    {
        id: 6,
        title: "The Thin Line An Artist",
        author: "Various Authors",
        cover: "assets/book-artist.jpg",
        price: "$12.99",
        rating: 4.4,
        description: "An exploration of art, creativity, and the fine line between inspiration and obsession. This book delves into the minds of great artists throughout history."
    },
    {
        id: 7,
        title: "Laws of UX: Design Principles",
        author: "Jon Yablonski",
        cover: "assets/book-ux.jpg",
        price: "$24.97",
        rating: 4.6,
        description: "A practical guide to apply key principles from psychology to build more intuitive, human-centered products and experiences."
    },
    {
        id: 8,
        title: "A Million To One",
        author: "Tony Faggioli",
        cover: "assets/book-million.jpg",
        price: "$9.97",
        rating: 4.3,
        description: "A gripping thriller that explores the odds of survival and the human spirit's resilience in the face of impossible challenges."
    }
];

// News Data
const newsData = [
    {
        id: 1,
        title: "5 Takeaways",
        subtitle: "The Psychology of Money",
        image: "assets/news1.jpg"
    },
    {
        id: 2,
        title: "The Psychology of Money",
        subtitle: "Book Review",
        image: "assets/news2.jpg"
    }
];

// Onboarding
let currentOnboarding = 1;

function nextOnboarding() {
    document.getElementById(`onboarding${currentOnboarding}`).classList.remove('active');
    currentOnboarding++;
    if (currentOnboarding <= 3) {
        document.getElementById(`onboarding${currentOnboarding}`).classList.add('active');
    }
}

function skipOnboarding() {
    getStarted();
}

function getStarted() {
    document.querySelectorAll('.onboarding-screen').forEach(screen => {
        screen.style.display = 'none';
    });
    document.getElementById('mainApp').style.display = 'block';
    initializeApp();
}

// Initialize App
function initializeApp() {
    loadRecommendedBooks();
    loadPopularBooks();
    loadNews();
    setupSearch();
}

// Load Books
function loadRecommendedBooks() {
    const container = document.getElementById('recommendedBooks');
    const recommended = booksData.slice(0, 5);
    
    container.innerHTML = recommended.map(book => `
        <div class="book-card" onclick="showBookDetail(${book.id})">
            <img src="${book.cover}" alt="${book.title}" onerror="this.src='https://via.placeholder.com/130x180/FF8B8B/FFFFFF?text=${encodeURIComponent(book.title)}'">
            <h5>${book.title}</h5>
            <p class="author">${book.author}</p>
        </div>
    `).join('');
}

function loadPopularBooks() {
    const container = document.getElementById('popularBooks');
    const popular = booksData.slice(3, 8);
    
    container.innerHTML = popular.map(book => `
        <div class="book-item" onclick="showBookDetail(${book.id})">
            <img src="${book.cover}" alt="${book.title}" onerror="this.src='https://via.placeholder.com/80x110/FF8B8B/FFFFFF?text=Book'">
            <div class="book-item-info">
                <div>
                    <h5>${book.title}</h5>
                    <p class="author">${book.author}</p>
                    <div class="rating">
                        ${generateStars(book.rating)}
                        <span>${book.rating}</span>
                    </div>
                </div>
                <p class="price">${book.price}</p>
            </div>
        </div>
    `).join('');
}

function loadNews() {
    const container = document.getElementById('newsSection');
    
    container.innerHTML = newsData.map(news => `
        <div class="news-card">
            <img src="${news.image}" alt="${news.title}" onerror="this.src='https://via.placeholder.com/250x140/4ECDC4/FFFFFF?text=News'">
            <div class="news-card-content">
                <h5>${news.title}</h5>
                <p>${news.subtitle}</p>
            </div>
        </div>
    `).join('');
}

// Generate Stars
function generateStars(rating) {
    const fullStars = Math.floor(rating);
    const halfStar = rating % 1 >= 0.5 ? 1 : 0;
    const emptyStars = 5 - fullStars - halfStar;
    
    let stars = '';
    for (let i = 0; i < fullStars; i++) {
        stars += '<i class="fas fa-star"></i>';
    }
    if (halfStar) {
        stars += '<i class="fas fa-star-half-alt"></i>';
    }
    for (let i = 0; i < emptyStars; i++) {
        stars += '<i class="far fa-star"></i>';
    }
    
    return stars;
}

// Show Book Detail
function showBookDetail(bookId) {
    const book = booksData.find(b => b.id === bookId);
    if (!book) return;
    
    document.getElementById('detailBookCover').src = book.cover;
    document.getElementById('detailBookCover').onerror = function() {
        this.src = `https://via.placeholder.com/140x200/FF8B8B/FFFFFF?text=${encodeURIComponent(book.title)}`;
    };
    document.getElementById('detailBookTitle').textContent = book.title;
    document.getElementById('detailBookAuthor').textContent = book.author;
    document.getElementById('detailBookRating').innerHTML = `
        ${generateStars(book.rating)}
        <span>${book.rating}</span>
    `;
    document.getElementById('detailBookPrice').textContent = book.price;
    document.getElementById('detailBookDescription').textContent = book.description;
    
    // Store current book ID for reading
    window.currentBookId = bookId;
    
    showScreen('detail');
}

// Show Tabs
function showTab(tabName) {
    document.querySelectorAll('.tab-btn').forEach(btn => btn.classList.remove('active'));
    document.querySelectorAll('.book-tab-content').forEach(content => content.style.display = 'none');
    
    event.target.classList.add('active');
    document.getElementById(`${tabName}Tab`).style.display = 'block';
}

// Start Reading
function startReading() {
    const book = booksData.find(b => b.id === window.currentBookId);
    if (!book) return;
    
    document.getElementById('readingTitle').textContent = book.title;
    document.getElementById('readingContent').innerHTML = `
        <h3>Chapter 1: Introduction</h3>
        <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.</p>
        <p>Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
        <p>Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo.</p>
        <p>Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt.</p>
    `;
    
    showScreen('reading');
}

// Reading Navigation
let currentPage = 1;
const totalPages = 10;

function previousPage() {
    if (currentPage > 1) {
        currentPage--;
        updatePageInfo();
    }
}

function nextPage() {
    if (currentPage < totalPages) {
        currentPage++;
        updatePageInfo();
    }
}

function updatePageInfo() {
    document.querySelector('.page-info').textContent = `Page ${currentPage} of ${totalPages}`;
}

// Screen Navigation
function showScreen(screenName) {
    document.querySelectorAll('.screen').forEach(screen => screen.classList.remove('active'));
    document.querySelectorAll('.nav-item').forEach(item => item.classList.remove('active'));
    
    const backBtn = document.getElementById('backBtn');
    
    switch(screenName) {
        case 'home':
            document.getElementById('homeScreen').classList.add('active');
            document.querySelector('.nav-item').classList.add('active');
            backBtn.style.display = 'none';
            break;
        case 'detail':
            document.getElementById('bookDetailScreen').classList.add('active');
            backBtn.style.display = 'block';
            backBtn.onclick = () => showScreen('home');
            break;
        case 'reading':
            document.getElementById('readingScreen').classList.add('active');
            backBtn.style.display = 'block';
            backBtn.onclick = () => showScreen('detail');
            break;
        case 'library':
            // Show library screen (to be implemented)
            alert('Library screen - Coming soon!');
            break;
        case 'favorites':
            // Show favorites screen (to be implemented)
            alert('Favorites screen - Coming soon!');
            break;
        case 'profile':
            // Show profile screen (to be implemented)
            alert('Profile screen - Coming soon!');
            break;
    }
}

// Menu Toggle
function toggleMenu() {
    const menu = document.getElementById('sideMenu');
    menu.classList.toggle('active');
    
    // Add overlay
    let overlay = document.querySelector('.overlay');
    if (!overlay) {
        overlay = document.createElement('div');
        overlay.className = 'overlay';
        overlay.onclick = toggleMenu;
        document.body.appendChild(overlay);
    }
    overlay.classList.toggle('active');
}

// Search Functionality
function setupSearch() {
    const searchInput = document.getElementById('searchInput');
    searchInput.addEventListener('input', (e) => {
        const query = e.target.value.toLowerCase();
        if (query.length > 2) {
            searchBooks(query);
        } else {
            loadRecommendedBooks();
            loadPopularBooks();
        }
    });
}

function searchBooks(query) {
    const results = booksData.filter(book => 
        book.title.toLowerCase().includes(query) || 
        book.author.toLowerCase().includes(query)
    );
    
    const container = document.getElementById('popularBooks');
    if (results.length > 0) {
        container.innerHTML = results.map(book => `
            <div class="book-item" onclick="showBookDetail(${book.id})">
                <img src="${book.cover}" alt="${book.title}" onerror="this.src='https://via.placeholder.com/80x110/FF8B8B/FFFFFF?text=Book'">
                <div class="book-item-info">
                    <div>
                        <h5>${book.title}</h5>
                        <p class="author">${book.author}</p>
                        <div class="rating">
                            ${generateStars(book.rating)}
                            <span>${book.rating}</span>
                        </div>
                    </div>
                    <p class="price">${book.price}</p>
                </div>
            </div>
        `).join('');
    } else {
        container.innerHTML = '<p style="text-align: center; padding: 20px; color: #999;">No books found</p>';
    }
}

// Open Book (from featured section)
function openBook(bookId) {
    showBookDetail(bookId);
}

// Check if user has completed onboarding before
window.addEventListener('load', () => {
    const hasCompletedOnboarding = localStorage.getItem('completedOnboarding');
    if (hasCompletedOnboarding) {
        getStarted();
    }
});

// Save onboarding completion
function getStarted() {
    localStorage.setItem('completedOnboarding', 'true');
    document.querySelectorAll('.onboarding-screen').forEach(screen => {
        screen.style.display = 'none';
    });
    document.getElementById('mainApp').style.display = 'block';
    initializeApp();
}
