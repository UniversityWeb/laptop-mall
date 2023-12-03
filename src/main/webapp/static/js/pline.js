import { Application } from '@splinetool/runtime';

const canvas_text = document.getElementById('canvas3d_text');
const canvas_laptop = document.getElementById('canvas3d_laptop');
const app_text = new Application(canvas_text);
const app_laptop = new Application(canvas_laptop);
app_text.load('https://prod.spline.design/p0h6SJoXgQOAkBLf/scene.splinecode');
app_laptop.load('https://prod.spline.design/pZbHpYt-c0Vk85uw/scene.splinecode');


