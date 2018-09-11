FROM node:8.9.4 AS build
WORKDIR /app
COPY package*.json ./
RUN npm install
COPY . .
RUN npm run build

### INSTALACAO DO NGINX
FROM nginx
COPY --from=build /app/build /usr/share/nginx/html
EXPOSE 80