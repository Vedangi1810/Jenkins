# Hackathon

Slide 1 - Intro

Good morning everyone. We are Team BhashaSetu, and our project is an offline AI-powered multilingual translation platform designed to translate documents, images, audio, and video into Indian languages. The core goal is to break language barriers in a secure, scalable, and internet-independent way.

slide 2 - Team

As a team, our focus was not just on translation itself, but on building a practical platform that can actually work in BAIF’s environment. That means supporting offline deployment, maintaining data privacy, and handling multiple content formats like documents, audio, video, and images within one unified system.

Slide 3 - Problem statement

The problem we are solving is that content exists in many formats—PDFs, images, training audio, and videos—but the intended users may not understand the original language. Manual translation in such cases is slow, expensive, and difficult to scale. At the same time, many organizations require an offline and secure solution, especially where internet connectivity is limited and data privacy is critical.

Slide 4 - Solution Overview

Our solution is BashaSetu: a single platform where a user can upload content in different formats, the system automatically detects the content type and source language, translates it into one or more selected target languages using offline AI models, and then generates the translated output for download.

slide 5 - Architecture :

This slide shows the overall architecture of BhashaSetu. At the top, users interact with a React + Vite frontend, which provides the repository, translation controls, and job tracking interface. The frontend communicates with a FastAPI backend through REST APIs.

The backend is the core orchestration layer—it manages file uploads, translation job creation, processing workflows, and download APIs. Based on the file type, the content is routed to the appropriate processing path: document extraction, OCR, speech-to-text, or video/audio extraction.

Once the content is extracted into text, we perform language detection, pass it to the offline translation engine, and then generate translated outputs such as PDFs, subtitles, or translated media. PostgreSQL is used to store metadata such as assets, translation jobs, job status, and output file paths.

Slide 6 - Technology stack :
We selected the stack based on simplicity, speed of development, and offline deployment. The frontend uses React with Vite for a lightweight and responsive user interface. The backend uses FastAPI, which is well-suited for building REST APIs and translation workflows. PostgreSQL is used to manage assets, jobs, and processing state reliably.

For AI processing, we use components like OCR, speech recognition, and translation models, depending on the input type.

Slide 7 - Repository module

The repository module acts as the entry point of the platform. Users upload files here, and each uploaded asset is stored with metadata such as filename, file type, source language, status, and file path. From this repository, users can initiate translation jobs for one or multiple target languages.

This module is important because it converts uploaded content into manageable translation assets that can be tracked, processed, and reused within the system.

Slide 8 - Flow Diagram I

For audio and video, the pipeline extends the same core architecture. We first extract audio where needed, convert speech into text using speech recognition, detect the language, and then translate the transcript into the selected target language. Depending on the output type, the system can then generate subtitles, translated text, or translated media outputs.

The key design decision here is that even though the input formats are different, they eventually converge into a common text translation pipeline. This makes the architecture more reusable, modular, and scalable.

Slide 9 - Flow Diagram II

This slide shows the core processing pipeline for text-based inputs such as documents or OCR-based content. Once the file is uploaded, we first extract text from the source—either directly from a PDF or through OCR in the case of image-based content. We then detect the source language, allow the user to choose one or more target languages, create translation jobs, and pass the extracted text to the translation engine. The translated content is then used to generate the final output file.

slide 10 - Database design

PostgreSQL is used to manage the state of the platform. At a minimum, we maintain two core entities: uploaded assets and translation jobs. The assets table stores information about the uploaded content, while the translation jobs table tracks source language, target language, processing status, output file path, and timestamps.

This is important because translation is not just a single synchronous action—it is a workflow that needs to be tracked, processed, retried if required, and downloaded later.

slide 11 - Future Scope

The current design establishes the core offline translation platform, and there are several natural extensions. We can expand support to 22+ Indian languages, add translation memory and custom glossaries for consistency, improve OCR quality for scanned documents, and enable batch processing for larger workloads.

From a product and deployment perspective, we can also add user authentication, mobile access, and enterprise-ready deployment features such as containerization and on-premise scaling.

slide 12 - Thank you

To conclude, BhashaSetu is our attempt to build a practical offline multilingual translation platform that can support multiple content types while remaining secure, modular, and scalable. Thank you.
