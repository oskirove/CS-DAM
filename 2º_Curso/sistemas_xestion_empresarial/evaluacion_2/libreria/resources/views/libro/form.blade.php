<div class="space-y-6">
    
    <div>
        <x-input-label for="categoria_id" :value="__('Categoria Id')"/>
        <x-text-input id="categoria_id" name="categoria_id" type="text" class="mt-1 block w-full" :value="old('categoria_id', $libro?->categoria_id)" autocomplete="categoria_id" placeholder="Categoria Id"/>
        <x-input-error class="mt-2" :messages="$errors->get('categoria_id')"/>
    </div>

    <div class="flex items-center gap-4">
        <x-primary-button>Submit</x-primary-button>
    </div>
</div>