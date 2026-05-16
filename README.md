# 📦 High-Volume Catalog Sales Center — OODB System
### **Mata Kuliah:** Sistem Basis Data Lanjut (SBDL)
**Program Studi:** Teknik Informatika — Universitas Bakrie  
**Tahun Akademik:** Genap 2026

---

## 📋 Deskripsi Proyek

Proyek ini merupakan implementasi sistem basis data berorientasi objek (OODB) untuk mensimulasikan **pusat penjualan katalog e-business bervolume tinggi** *(High-Volume Catalog Sales Center — Case 2)*. Proyek ini bertujuan untuk menganalisis dan mengoptimalkan ketersediaan data (*data availability*) dari status saat ini (99.9%) menuju target industri yang lebih tinggi menggunakan teknologi basis data berorientasi objek.

### Latar Belakang Proyek (Case 2)

| Aspek | Detail |
|-------|--------|
| **Status Availability** | 99.9% (saat ini) |
| **Tantangan** | Mengatasi keluhan berkala pelanggan akibat *downtime*/*data outages* |
| **Solusi Teknis** | Migrasi ke Object-Oriented Database (OODB) menggunakan **db4o** untuk pemodelan data yang lebih kompleks |

---

## 👥 Tim Proyek & Pembagian Tugas

| Nama Lengkap | NIM | Peran / Tanggung Jawab Utama |
|:---|:---|:---|
| **Akbar Raditya Pratama** | 1242001016 | Metodology, Dokumentation & Github Management |
| **Nikita Dwi Qoriah** | 1242001035 | Entity Relationship Diagram & Class Diagram Design |
| **Rafiif Muhammad Daffa** | 1242001004 | Object Diagram, Testing & Slide Presentation |
| **Shakyawan Bagus Wijaya** | 1242001026 | Object Oriented Database & Application CLI Development |

---

## 🛠️ Tech Stack & Komponen Sistem

| Komponen | Teknologi | Detail Implementasi |
|----------|-----------|---------------------|
| **Language** | Java | JDK 8+ / Implementasi Berorientasi Objek |
| **Database Engine** | db4o | Object-Oriented Database (Version 7 / 8) |
| **IDE** | Eclipse IDE | Lingkungan Pengembangan Utama |
| **Modeling (ERD)** | Draw.io | Perancangan Extended Entity-Relationship Diagram |
| **Modeling (Diagram)** | Papyrus | Perancangan Class Diagram & Object Diagram |
| **Interface** | Java CLI | Command Line Interface Menu pada Console |

---

## 📂 Struktur Proyek di GitHub

```
SBDL-Project-2026/
│
├── src/                       # Folder project utama dari Eclipse IDE
│   └── Eclipse_File_Kelompok2_SBDL.UTS/
│       ├── .settings/
│       ├── bin/
│       └── src/
│           └── utsdb4o/       # Paket kodingan Java (.java) kelompok
│
├── diagrams/                  # File diagram (ERD, Class Diagram, Object Diagram)
│   ├── E-ERD-Case2-Kelompok2-SBDL.drawio.png
│   └── ClassDiagram-case2-Kelompok2-SBDL.UTS/ # Folder Papyrus (.uml, .di, .notation)
│
├── docs/                      # Dokumentasi & log file
│   └── query-log.txt          # Catatan eksekusi query log
│
├── lib/                       # Library database external engine
│   └── db4o-7.2.44.10823-java.jar
│
└── README.md                  # File dokumentasi ini
```

---

## 📐 Deliverables & Implementasi Query

### 1. Desain Basis Data Berorientasi Objek

* **E-ERD:** Representasi diagram relasi entitas untuk High-Volume Sales Center
  - File: `diagrams/E-ERD-Case2-Kelompok2-SBDL.drawio.png`

* **Class Diagram:** Pemodelan struktural komponen sistem OODB menggunakan Papyrus
  - File: `diagrams/ClassDiagram-case2-Kelompok2-SBDL.UTS/`

* **Object Diagram:** Instansiasi minimal 3 kelas objek berbeda
  - File: `diagrams/ClassDiagram-case2-Kelompok2-SBDL.UTS/` (dalam folder Papyrus)

### 2. Skema Logika Object Query Language (OQL)

Sistem mengimplementasikan total **18 Query** yang dibagi ke dalam 3 metode utama db4o:

#### A. Query-By-Example (QBE) — 6 Queries
Eksekusi query menggunakan contoh pola objek langsung (Operasi: `SELECT`, `UPDATE`, `DELETE`)

#### B. Native Queries (NQ) — 6 Queries
Pencarian data menggunakan kode Java murni tipe aman (*type-safe* predicate)

#### C. SODA (Simple Object Database Access) Queries — 6 Queries
Query tingkat lanjut berbasis *graph-navigation tree* dengan kriteria logika kompleks

---

## 🚀 Cara Menjalankan Project di Eclipse

### 1. Build Path Setup
1. Pastikan project folder `Eclipse_File_Kelompok2_SBDL.UTS` sudah di-import ke Eclipse IDE
2. Klik kanan pada project → pilih **Properties**
3. Pilih menu **Java Build Path** → Tab **Libraries** → Klik **Add External JARs**
4. Arahkan ke folder `/lib` dan pilih file `db4o-7.2.44.10823-java.jar`

### 2. Jalankan Aplikasi
* Buka folder `src/utsdb4o/` di Eclipse
* Klik kanan file `Main.java` → **Run As** → **Java Application**
* Menu interaktif Command Line Interface (CLI) akan aktif di tab **Console** Eclipse

---

## 📌 Lampiran & Dokumentasi Akhir

| Dokumentasi | Link |
|---|---|
| 📺 Video Demonstrasi Proyek | [YouTube Link](ISI_LINK_YOUTUBE_DISINI) |
| 📑 Slide Presentasi Proyek (PDF) | [Slide Link](ISI_LINK_SLIDE_DISINI) |
| 📁 Main Repository Proyek | [GitHub Repo](https://github.com/AkbarRadityaPrataman/SBDL-Project-2026) |

---

<div align="center">
  <sub>© 2026 — Kelompok 2 SBDL | Program Studi Teknik Informatika, Universitas Bakrie</sub>
</div>
