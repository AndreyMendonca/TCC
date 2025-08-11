"use client"

import { CircleUserRoundIcon, XIcon } from "lucide-react"

import { useFileUpload } from "@/hooks/use-file-upload"
import { Button } from "@/components/ui/button"

export default function InputFotoPerfil() {
    const [{ files }, { removeFile, openFileDialog, getInputProps }] =
        useFileUpload({
            accept: "image/*",
        })

    const previewUrl = files[0]?.preview || null

    return (
        <div className="flex flex-col items-center gap-2">
            <div className="relative inline-flex">
                <Button
                    variant="outline"
                    className="relative size-16 overflow-hidden p-0 shadow-none"
                    onClick={openFileDialog}
                    aria-label={previewUrl ? "Trocar Imagem" : "Enviar Imagem"}
                >
                    {previewUrl ? (
                        <img
                            className="size-full object-cover"
                            src={previewUrl}
                            alt="Imagem de perfil"
                            width={64}
                            height={64}
                            style={{ objectFit: "cover" }}
                        />
                    ) : (
                        <div aria-hidden="true">
                            <CircleUserRoundIcon className="size-4 opacity-60" />
                        </div>
                    )}
                </Button>
                {previewUrl && (
                    <Button
                        onClick={() => removeFile(files[0]?.id)}
                        size="icon"
                        className="border-background focus-visible:border-background absolute -top-2 -right-2 size-6 rounded-full border-2 shadow-none"
                        aria-label="Remover Imagem"
                    >
                        <XIcon className="size-3.5" />
                    </Button>
                )}
                <input
                    {...getInputProps()}
                    className="sr-only"
                    aria-label="Fazer upload de uma imagem"
                    tabIndex={-1}
                />
            </div>
            <p
                aria-live="polite"
                role="region"
                className="text-muted-foreground text-xs"
            >
                Foto de Perfil
            </p>
        </div>
    )
}
