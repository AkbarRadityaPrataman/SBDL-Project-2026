# 📦 High-Volume Catalog Sales Center — OODB System
> **Mata Kuliah:** Sistem Basis Data Lanjut (SBDL)
> **Program Studi:** Teknik Informatika — Universitas Bakrie
> **Tahun:** 2026

---

## 📋 Deskripsi Proyek

Proyek ini merupakan implementasi sistem basis data berorientasi objek (OODB) untuk mensimulasikan **pusat penjualan katalog e-business** bervolume tinggi *(High-Volume Catalog Sales Center — Case 2)*.

### Latar Belakang

| Aspek | Detail |
|-------|--------|
| **Status Availability** | 99.9% (saat ini) |
| **Tantangan** | Keluhan pelanggan akibat downtime/outage |
| **Solusi** | Migrasi ke Object-Oriented Database (OODB) menggunakan **db4o** |

Migrasi ini bertujuan mengoptimalkan performa sistem dan memungkinkan pengelolaan struktur data yang lebih kompleks dibandingkan pendekatan relasional tradisional.

---

## 👥 Tim Proyek

| Nama | NIM | Peran |
|------|-----|-------|
| Akbar Raditya Prataman | 1242001016 | Lead Developer & ODL/OQL Implementation |
| Nikita Dwi Qoriah | 1242001035 | System Analyst & E-ERD Design |
| Rafiif Muhammad Daffa | 1242001004 | Database Architecture & Diagramming |
| Shakyawan Bagus Wijaya | 1242001026 | CLI Application & Quality Assurance |

---

## 🛠️ Tech Stack

| Komponen | Teknologi |
|----------|-----------|
| **Language** | Java (JDK 8+) |
| **Database Engine** | db4o (Object-Oriented Database) |
| **IDE** | Eclipse IDE |
| **Modeling (ERD)** | Draw.io |
| **Modeling (Class/Object)** | Papyrus |
| **Interface** | Java CLI (Command Line Interface) |

---

## 🚀 Cara Menjalankan Project

### 1. Clone Repository
```bash
git clone https://github.com/AkbarRadityaPrataman/Project-System-Basis-Data-Lanjut.git
cd Project-System-Basis-Data-Lanjut
```

### 2. Setup Library db4o
- Download `db4o-X.X.jar` (sesuaikan versi)
- Buka project di **Eclipse IDE**
- Klik kanan project → **Build Path** → **Add External Archives**
- Pilih file `.jar` yang telah di-download
- Pastikan library muncul di **Referenced Libraries**

### 3. Jalankan Aplikasi
- Buka folder `src/`
- Jalankan file `Main.java`
- Atau melalui terminal:
```bash
javac -cp .;db4o-X.X.jar src/Main.java
java -cp .;db4o-X.X.jar Main
```

---

## 📂 Struktur Proyek

```
Project-System-Basis-Data-Lanjut/
│
├── src/
│   ├── Main.java                  # Entry point aplikasi CLI
│   ├── model/                     # Class model / ODL schema
│   ├── query/
│   │   ├── QBEQueries.java        # Query By Example (6 queries)
│   │   ├── NativeQueries.java     # Native Queries (6 queries)
│   │   └── SODAQueries.java       # SODA Queries (6 queries)
│   └── util/                      # Utility & helper classes
│
├── diagrams/
│   ├── E-ERD.drawio               # Entity-Relationship Diagram
│   ├── ClassDiagram.uml           # Class Diagram (Papyrus)
│   └── ObjectDiagram.uml          # Object Diagram (min. 3 instances)
│
├── docs/
│   ├── query-log.txt              # Log hasil eksekusi query
│   └── presentation.pdf          # Slide presentasi
│
├── lib/
│   └── db4o-X.X.jar              # Library db4o
│
└── README.md
```

---

## 📐 Deliverables

### 1. 🗂️ Database Design

#### E-ERD (Extended Entity-Relationship Diagram)
Representasi visual entitas bisnis dan relasinya, dibuat menggunakan **Draw.io**.

#### Class Diagram
Struktur kelas Java yang menjadi skema OODB, mencakup:
- Atribut setiap kelas
- Operasi/method yang tersedia
- Relasi antar kelas

#### Object Diagram
Contoh instance data nyata dari sistem, dengan **minimal 3 contoh objek** beserta nilai atributnya.

---

### 2. 💾 Implementasi OODB (db4o)

#### ODL — Object Definition Language
Pendefinisian skema menggunakan Java class, mencakup operasi:
- **Create** — Menambahkan objek baru ke database
- **Update** — Memperbarui data objek yang ada
- **Delete** — Menghapus objek dari database

#### OQL — Object Query Language

**QBE (Query By Example)** — 6 Query
| No | Tipe | Deskripsi |
|----|------|-----------|
| 1 | SELECT | Menampilkan semua data entitas utama |
| 2 | SELECT | Filter berdasarkan kondisi tertentu |
| 3 | SELECT | Relasi antar dua entitas |
| 4 | UPDATE | Memperbarui data berdasarkan kondisi |
| 5 | UPDATE | Pembaruan massal (bulk update) |
| 6 | DELETE | Menghapus data berdasarkan kriteria |

**Native Queries (NQ)** — 6 Query
| No | Tipe | Deskripsi |
|----|------|-----------|
| 1 | Filter | Seleksi dengan kondisi tunggal |
| 2 | Filter | Seleksi dengan kondisi majemuk |
| 3 | Filter | Filter berbasis relasi objek |
| 4 | Sort | Pengurutan ascending |
| 5 | Sort | Pengurutan descending |
| 6 | Filter + Sort | Kombinasi filter dan pengurutan |

**SODA (Simple Object Database Access)** — 6 Query
| No | Logika | Deskripsi |
|----|--------|-----------|
| 1 | AND | Kombinasi dua kondisi AND |
| 2 | OR | Kombinasi dua kondisi OR |
| 3 | NOT | Negasi kondisi |
| 4 | AND + OR | Kondisi kompleks berlapis |
| 5 | NOT + AND | Negasi dengan kondisi tambahan |
| 6 | AND + OR + NOT | Kombinasi penuh tiga operator logika |

---

### 3. 🖥️ CLI Application

Aplikasi berbasis teks interaktif yang memungkinkan pengguna melakukan operasi database secara langsung melalui terminal.

**Fitur CLI:**
- Menu navigasi interaktif
- Eksekusi query QBE, NQ, dan SODA
- Tampilan hasil query terformat
- Operasi CRUD lengkap

---

## 📌 Lampiran & Dokumentasi

| Sumber | Link |
|--------|------|
| 📺 Video Demonstrasi | [Tonton di YouTube](#) |
| 📑 Slide Presentasi (PDF) | [Lihat Dokumen](#) |
| 📝 Query Log (.txt) | [Buka Query Log](#) |

> ⚠️ *Ganti `#` di atas dengan URL sebenarnya setelah diupload.*

---

## 📚 Referensi

- [db4o Documentation](https://sourceforge.net/projects/db4o/)
- [Java SE 8 Documentation](https://docs.oracle.com/javase/8/docs/)
- Connolly, T. & Begg, C. — *Database Systems: A Practical Approach to Design, Implementation, and Management*

---

## 📄 Lisensi

Proyek ini dibuat untuk keperluan akademik dalam rangka pemenuhan tugas mata kuliah **Sistem Basis Data Lanjut**, Program Studi Teknik Informatika, Universitas Bakrie.

---

<div align="center">
  <sub>© 2026 — Kelompok SBDL | Teknik Informatika, Universitas Bakrie</sub>
</div>
