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

For audio and video, the initial steps are different. For video, FFmpeg is used to extract the audio track, while audio files go directly into processing. After that, both follow the same common pipeline: Whisper converts speech to text, the system detects the language, translates the text, and generates the final output. The difference is only in the final result—audio gives translated speech, while video gives subtitles or dubbed video.

Slide 9 - Flow Diagram II

This slide shows the core processing pipeline for text-based inputs such as documents or OCR-based content. Once the file is uploaded, we first extract text from the source—either directly from a PDF or through OCR in the case of image-based content. We then detect the source language, allow the user to choose one or more target languages, create translation jobs, and pass the extracted text to the translation engine. The translated content is then used to generate the final output file.

slide 10 - Database design

PostgreSQL stores the platform data such as uploaded assets and translation jobs. Assets keep file details, while translation jobs track source language, target language, status, and output.This makes the system reliable and helps manage translation as a complete process rather than a single action.”

slide 11 - Future Scope

In future, BhashaSetu can be extended with support for 22+ Indian languages, better OCR, translation memory, batch processing, user authentication, mobile access, and scalable on-premise deployment.

slide 12 - Thank you

To conclude, BhashaSetu is our attempt to build a practical offline multilingual translation platform that can support multiple content types while remaining secure, modular, and scalable. Thank you.
